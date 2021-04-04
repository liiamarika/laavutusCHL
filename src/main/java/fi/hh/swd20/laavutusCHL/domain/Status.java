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
public class Status {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long statusid;
	private String state;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="status")
	@JsonIgnoreProperties("status")  // tällä vältetään JSON serialization/deserialization looppi
	private List<Fire> fires;
	
	// constructors
	
	public Status() {}

	public Status(String state) {
		super();
		this.state = state;
	}
	
	// setters, getters, toString ilman listausta
	
	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return state;
	}

	
	

	
}
