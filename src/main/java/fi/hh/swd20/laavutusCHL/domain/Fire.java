package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//entity edustaa taulua relaatiotietokannassa, table name = name of the entity class
@Entity
public class Fire {
	
	@Id // luodaan id columni
	@GeneratedValue(strategy= GenerationType.AUTO) // generoidaan uniikki id
	private Long id;
	private String name;
	private String location;
	private String coordinates;
	
	@ManyToOne
	@JsonIgnoreProperties("fires")// vältetään looppi: JSON serialization/deserialization with bidirectional relationships
	@JoinColumn(name="ctgrid") // määrittää suhteen omistajaosapuolen, toisessa on viiteavain
	private Category category;
	@ManyToOne
	@JsonIgnoreProperties("fires")// vältetään looppi: JSON serialization/deserialization with bidirectional relationships
	@JoinColumn(name="statusid")
	private Status status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="fire")
	@JsonIgnoreProperties("fire")  // tällä vältetään JSON serialization/deserialization looppi
	private List<Review> reviews;
	
	// constructors
	
	public Fire () {}
	
	public Fire(String name, String location, String coordinates, Category category, Status status) {
		super();
		this.name = name;
		this.location = location;
		this.coordinates = coordinates;
		this.category = category;
		this.status = status;
	}
	
	// setters, getters, toString 	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		if (this.category != null && this.status != null)
			return "Fire [id: " + id + ", name: " + name + ", location: " + location + ", coordinates: " + coordinates + ", category: " + this.getCategory() + ", status: " + this.getStatus();
		else if (this.category == null && this.status != null)
		return "Fire [id: " + id + ", name: " + name + ", location: " + location + ", coordinates: " + coordinates + ", status: " + this.getStatus();
			else if (this.category != null && this.status == null)
			return "Fire [id: " + id + ", name: " + name + ", location: " + location + ", coordinates: " + coordinates + ", category " + this.getCategory();
		else
			return "Fire [id: " + id + ", name: " + name + ", location: " + location + ", coordinates: " + coordinates;
	}
	
}
