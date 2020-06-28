package com.book.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SeatDetail {
	@Id
	private int seatNo;
	private String seatName;

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

}
