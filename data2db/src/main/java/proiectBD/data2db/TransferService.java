package proiectBD.data2db;

import java.util.Calendar;

import org.hibernate.Session;

public class TransferService {

	public static void main(String[] args) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
//		String sql = "select version()";
//		
//		String result = (String)session.createNativeQuery(sql).getSingleResult();
//		System.out.println(result);

		
		AirbnbTableEntry entry = new AirbnbTableEntry();
		entry.setRoom_id("ROOM_ID");
		entry.setHost_id("HOST_ID");
		entry.setRoom_type("ROOMT_YPE");
		entry.setBorough("BOROUGH");
		entry.setNeighborhood("NEIGHBORHOOD");
		entry.setReviews(100);
		entry.setOverall_satisfaction(5.0f);
		entry.setAccommodates(10);
		entry.setBedrooms(5);
		entry.setPrice(500.23f);
		entry.setMinstay(10);
		entry.setLatitude(42.35f);
		entry.setLongitude(9.21f);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		calendar.set(Calendar.HOUR_OF_DAY, 16);
		calendar.set(Calendar.SECOND, 55);
		calendar.set(Calendar.MILLISECOND, 960);
		entry.setLast_modified(calendar.getTime());
		
		session.save(entry);
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
	}

}
