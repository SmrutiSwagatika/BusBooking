package com.book.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookingDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	@ManyToOne
	@JoinColumn(name = "journyId")
	private BusDetail busdetail;
	private String seatNo;
	private String busNo;
	private String journyDate;
	private Double bookinfPrice;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public BusDetail getBusdetail() {
		return busdetail;
	}

	public void setBusdetail(BusDetail busdetail) {
		this.busdetail = busdetail;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getJournyDate() {
		return journyDate;
	}

	public void setJournyDate(String journyDate) {
		this.journyDate = journyDate;
	}

	public Double getBookinfPrice() {
		return bookinfPrice;
	}

	public void setBookinfPrice(Double bookinfPrice) {
		this.bookinfPrice = bookinfPrice;
	}

}
