package com.book.pojo;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BusDetail {
	@Id
	private int journyId;
	@OneToMany
	@JoinColumn(name = "journyId")
	private List<BookingDetail> booking;
	private String busNo;
	private String sourceCity;
	private String destinationCity;
	private String travelDate;
	private String operatorName;
	private Date dapartureTime;
	private Date arrivalTime;
	private Time duration;
	private double price;

	public int getJournyId() {
		return journyId;
	}

	public void setJournyId(int journyId) {
		this.journyId = journyId;
	}

	public List<BookingDetail> getBooking() {
		return booking;
	}

	public void setBooking(List<BookingDetail> booking) {
		this.booking = booking;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Date getDapartureTime() {
		return dapartureTime;
	}

	public void setDapartureTime(Date dapartureTime) {
		this.dapartureTime = dapartureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
