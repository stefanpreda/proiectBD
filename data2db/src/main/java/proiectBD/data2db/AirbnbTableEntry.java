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

	/*Use wrapper classes because values can be null*/
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
	private Integer reviews;
	
	@Column(name = "overall_satisfaction")
	private Float overall_satisfaction;
	
	@Column(name = "accommodates")
	private Integer accommodates;
	
	@Column(name = "bedrooms")
	private Integer bedrooms;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "minstay")
	private Integer minstay;
	
	@Column(name = "longitude")
	private Float longitude;
	
	@Column(name = "latitude")
	private Float latitude;
	
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

	public Integer getReviews() {
		return reviews;
	}

	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}

	public Float getOverall_satisfaction() {
		return overall_satisfaction;
	}

	public void setOverall_satisfaction(Float overall_satisfaction) {
		this.overall_satisfaction = overall_satisfaction;
	}

	public Integer getAccommodates() {
		return accommodates;
	}

	public void setAccommodates(Integer accommodates) {
		this.accommodates = accommodates;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getMinstay() {
		return minstay;
	}

	public void setMinstay(Integer minstay) {
		this.minstay = minstay;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Date getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(Date last_modified) {
		this.last_modified = last_modified;
	}
	
	
}
