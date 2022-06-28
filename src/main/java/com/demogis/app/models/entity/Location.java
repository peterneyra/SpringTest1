package com.demogis.app.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.geo.Point;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="locations")
public class Location implements Serializable {

	private static final long serialVersionUID = -2657149979241467566L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private Long locationId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_locationid" )
	private User usuario;
	
	
	@Column(name = "user_id")
	private Long userId;	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@Column(name = "create_on")
	private Timestamp createOn;	
	
	private Double latitud;
	private Double longitud;
	
//	@Transient
//	private String sLatitud;
//	@Transient
//	private String sLongitud;	

	
	
	@PrePersist
	public void prePersist() {	
		Timestamp ts = new java.sql.Timestamp( new Date().getTime() );
		createOn = ts;
	}
	
	
	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Timestamp getCreateOn() {
		return createOn;
	}
	public void setCreateOn(Timestamp createOn) {
		this.createOn = createOn;
	}


	public Double getLatitud() {
		return latitud;
	}


	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}


	public Double getLongitud() {
		return longitud;
	}


	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	
	
	

	
	
}
