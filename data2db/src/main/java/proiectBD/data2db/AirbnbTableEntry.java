package proiectBD.data2db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airbnb_data")
public class AirbnbTableEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "room_id")
	private String room_id;
	
	@Column(name = "host_id")
	private String host_id;
	
	@Column(name = "room_type")
	private String room_type;
	
	@Column(name = "borough")
	private String borough;
	
	@Column(name = "neighborhood")
	private String neighborhood;
	
	@Column(name = "reviews")
	private int reviews;
	
	@Column(name = "overall_satisfaction")
	private float overall_satisfaction;
	
	@Column(name = "accommodates")
	private int accommodates;
	
	@Column(name = "bedrooms")
	private int bedrooms;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "minstay")
	private int minstay;
	
	@Column(name = "longitude")
	private float longitude;
	
	@Column(name = "latitude")
	private float latitude;
	
	@Column(name = "last_modified")
	private Date last_modified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getBorough() {
		return borough;
	}

	public void setBorough(String borough) {
		this.borough = borough;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getReviews() {
		return reviews;
	}

	public void setReviews(int reviews) {
		this.reviews = reviews;
	}

	public float getOverall_satisfaction() {
		return overall_satisfaction;
	}

	public void setOverall_satisfaction(float overall_satisfaction) {
		this.overall_satisfaction = overall_satisfaction;
	}

	public int getAccommodates() {
		return accommodates;
	}

	public void setAccommodates(int accommodates) {
		this.accommodates = accommodates;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getMinstay() {
		return minstay;
	}

	public void setMinstay(int minstay) {
		this.minstay = minstay;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Date getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}
	
}
