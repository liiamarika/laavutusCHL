package fi.hh.swd20.laavutusCHL.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long rid;
	@NotEmpty (message="Nimimerkki puuttuu")
	private String nick;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String subject;
	@Size(min=5, max=100, message="Arvion pitää olla 5-100 merkkiä")
	private String text;

	@ManyToOne
	@JsonIgnoreProperties("reviews")// vältetään looppi: JSON serialization/deserialization with bidirectional relationships
	@JoinColumn(name="id")
	private Fire fire;
	
	// constructors
	
	public Review () {}

	public Review(String nick, Date date, String subject, String text, Fire fire) {
		super();
		this.nick = nick;
		this.date = date;
		this.subject = subject;
		this.text = text;
		this.fire = fire;
	}

	
	// setters, getters, toString 	
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Fire getFire() {
		return fire;
	}

	public void setFire(Fire fire) {
		this.fire = fire;
	}

	@Override
	public String toString() {
		if (this.fire != null)
		return "Review [rid=" + rid + ", nick=" + nick + ", startDay=" + date + ", subject=" + subject + ", text="
				+ text + ", fire=" + this.getFire();
		else 
			return "Review [rid=" + rid + ", nick=" + nick + ", startDay=" + date + ", subject=" + subject + ", text="
					+ text;
	}

	
	
}
