package com.demogis.app.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The {@code User} class represents the relevant data of the user, 
 * the {@code userId} and {@code createOnUser} fields cannot be modified, 
 * alternative fields should be used in the case that you want to modify. 
 * {@code createOnUserChanged} and {@code idUser}
 * @author Peter
 *
 */

@Entity
@Table(name="users") //,indexes=@Index(name="idx_locations",columnList="user_id,create_on_user,id_user")) 
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	// crear automatica lallave usuario_id en tabla Locations @JsonIgnore
	@OneToMany(mappedBy = "usuario" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	 @JsonIgnore
	private List<Location> listLocations;
	
	
	//@Temporal( TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@Column(name = "create_on_user")
	private Timestamp  createOnUser;
		
	@Column(name = "id_user")
	private String idUser;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@Column(name = "create_on_user_changed")
	private Timestamp  createOnUserChanged;
	
	@Column(name = "email")
	private String email;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "is_mobile")
	private String isMobile;
	
	@Column(name = "last_latitud")
	private Double lastLatitud;
	@Column(name = "last_longitud")
	private Double lastLongitud;
	
	@Transient
	private String latitud;
	@Transient
	private String longitud;
	
	//@Temporal( TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	@Column(name = "create_on_location")
	private Timestamp  createOnLocation;
	
	
	
	@PrePersist
	public void prePersist() {	
		Timestamp ts = new java.sql.Timestamp( new Date().getTime() );
		createOnUser = ts;
		createOnUserChanged = ts;
		createOnLocation = ts;
	}

	
	
	public User() {
		listLocations = new ArrayList<Location>();
	}
	public void addLocations(Location location) {
		listLocations.add(location);
	}
	
	
	public List<Location> getListLocations() {
		return listLocations;
	}
	public void setListLocations(List<Location> listLocations) {
		this.listLocations = listLocations;
	}
	

	


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Timestamp getCreateOnUser() {
		return createOnUser;
	}

	public void setCreateOnUser(Timestamp createOnUser) {
		this.createOnUser = createOnUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}

	public Double getLastLatitud() {
		return lastLatitud;
	}

	public void setLastLatitud(Double lastLatitud) {
		this.lastLatitud = lastLatitud;
	}

	public Double getLastLongitud() {
		return lastLongitud;
	}

	public void setLastLongitud(Double lastLongitud) {
		this.lastLongitud = lastLongitud;
	}

	public Timestamp getCreateOnLocation() {
		return createOnLocation;
	}

	public void setCreateOnLocation(Timestamp createOnLocation) {
		this.createOnLocation = createOnLocation;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Timestamp getCreateOnUserChanged() {
		return createOnUserChanged;
	}

	public void setCreateOnUserChanged(Timestamp createOnUserChanged) {
		this.createOnUserChanged = createOnUserChanged;
	}

	public String getLatitud() {
		if (lastLatitud != null) this.latitud = lastLatitud.toString();
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.lastLatitud = Double.parseDouble(latitud) ;
		this.latitud = latitud;
	}

	public String getLongitud() {
		if (lastLongitud != null ) this.longitud = lastLongitud.toString();
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.lastLongitud = Double.parseDouble(longitud) ;
		this.longitud = longitud;
	}







	

}
