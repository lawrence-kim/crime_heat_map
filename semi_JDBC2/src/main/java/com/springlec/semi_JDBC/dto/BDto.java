package com.springlec.semi_JDBC.dto;

import java.sql.Timestamp;


public class BDto {

//	Field
	int bId;
	String bName;
	String bTel;
	String bAddress;
	String bEmail;
	String bRelation;
	Timestamp bDate;
	
	String YEAR;
	String Latitude;
	String Longitude;

	String Weather;
	
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}

	public BDto(int bId, String bName, String bTel, String bAddress, String bEmail, String bRelation, Timestamp bDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTel = bTel;
		this.bAddress = bAddress;
		this.bEmail = bEmail;
		this.bRelation = bRelation;
		this.bDate = bDate;

	}
	
	
	
	
	
	
	
	
	// ----------------------
	
	public BDto(String weather) {
		super();
		Weather = weather;
	}
	





	public BDto(String latitude, String longitude) {
		super();
		Latitude = latitude;
		Longitude = longitude;
	}

	
	//----------------------
	
	public String getWeather() {
		return Weather;
	}

	public void setWeather(String weather) {
		Weather = weather;
	}
	


	public int getbId() {
		return bId;
	}



	public String getYEAR() {
		return YEAR;
	}

	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTel() {
		return bTel;
	}

	public void setbTel(String bTel) {
		this.bTel = bTel;
	}

	public String getbAddress() {
		return bAddress;
	}

	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getbEmail() {
		return bEmail;
	}

	public void setbEmail(String bEmail) {
		this.bEmail = bEmail;
	}

	public String getbRelation() {
		return bRelation;
	}

	public void setbRelation(String bRelation) {
		this.bRelation = bRelation;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}


	
	
	
	

}
