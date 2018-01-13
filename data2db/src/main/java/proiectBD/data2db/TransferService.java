package proiectBD.data2db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class TransferService
{

	public static final int BATCH_SIZE = 50;
	public static final DateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage: java -jar data2db-0.0.1-SNAPSHOT-jar-with-dependencies.jar <file>");
			return;
		}
		
		File file = new File(args[0]);
		
		if (!file.exists() || !file.canRead())
		{
			System.err.print("Could not open file for reading!");
		}
		
		/* Initialize parser */
		CsvParserSettings settings = new CsvParserSettings();
		settings.getFormat().setDelimiter(',');
		settings.getFormat().setLineSeparator("\n");		
		CsvParser parser = new CsvParser(settings);
		
		Session session = null;
		
		try
		{
			/* Start DB session and transaction*/
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			
			/*Start parsing the file*/
			parser.beginParsing(new FileReader(args[0]));
			String[] row;
			int index = 0;
			
			/*Skip row with column titles*/
			parser.parseNext();
			
			while ((row = parser.parseNext()) != null)
			{
				AirbnbTableEntry entry = getNewTableEntry(row);
				
				session.save(entry);
				index++;
				
				if (index % BATCH_SIZE == 0)
				{
					session.flush();
					session.clear();
				}
			}
			
			session.getTransaction().commit();
			session.close();
		}
		catch (HibernateException e)
		{
			if (session != null)
			{
				if (session.getTransaction() != null)
					session.getTransaction().rollback();
				session.close();
			}
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtil.shutdown();
		}
	}
	
	public static AirbnbTableEntry getNewTableEntry(String[] fields)
	{
		AirbnbTableEntry entry = new AirbnbTableEntry();
		
		entry.setRoom_id(fields[0]);
		entry.setHost_id(fields[1]);
		entry.setRoom_type(fields[2]);
		entry.setBorough(fields[3]);
		entry.setNeighborhood(fields[4]);
		
		if (fields[5] != null)
			entry.setReviews(Integer.parseInt(fields[5]));
		else
			entry.setReviews(null);
		
		if (fields[6] != null)
			entry.setOverall_satisfaction(Float.parseFloat(fields[6]));
		else
			entry.setOverall_satisfaction(null);
		
		if (fields[7] != null)
			entry.setAccommodates(Integer.parseInt(fields[7]));
		else
			entry.setAccommodates(null);
		
		if (fields[8] != null)
			entry.setBedrooms((int)Float.parseFloat(fields[8]));
		else
			entry.setBedrooms(null);
		
		if (fields[9] != null)
			entry.setPrice(Float.parseFloat(fields[9]));
		else
			entry.setPrice(null);
		
		if (fields[10] != null)
			entry.setMinstay((int)Float.parseFloat(fields[10]));
		else
			entry.setMinstay(null);
		
		if (fields[11] != null)
			entry.setLatitude(Float.parseFloat(fields[11]));
		else
			entry.setLatitude(null);
		
		if (fields[12] != null)
			entry.setLongitude(Float.parseFloat(fields[12]));
		else
			entry.setLongitude(null);
		
		if (fields[13] != null)
		{
			Date date = null;
			
			try
			{
				date = DATE_FORMAT.parse(fields[13]);
			}
			catch (ParseException e)
			{
				System.err.println("Could not parse: " + fields[13]);
			}
			
			entry.setLast_modified(date);
		}
		else
			entry.setLast_modified(null);
		
		return entry;
	}

}
