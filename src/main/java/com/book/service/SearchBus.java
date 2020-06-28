package com.book.service;

import java.util.List;
import com.book.pojo.BookingDetail;
import com.book.pojo.BusDetail;

public interface SearchBus {
	List<BusDetail> search(String source, String destination, String travelDate);

	String bookSeat(String busNo, String seat, String travelDate, int journeyId, double price);

	List<BookingDetail> getOccupiedSeat(String busNo, String travelDate);

	List<String> getTotalList();
}
