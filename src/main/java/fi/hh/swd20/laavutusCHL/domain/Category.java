package fi.hh.swd20.laavutusCHL.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ctgrid;
	private String type;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	@JsonIgnoreProperties("category")  // tällä vältetään JSON serialization/deserialization looppi
	private List<Fire> fires;
	
	// constructors 
	
	public Category() {}

	public Category(String type) {
		super();
		this.type = type;
	}
	
	// setters, getters, toString ilman listausta

	public Long getCtgrid() {
		return ctgrid;
	}

	public void setCtgrid(Long ctgrid) {
		this.ctgrid = ctgrid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}
	

	
	
	
}