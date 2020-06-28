package com.book.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.book.pojo.BookingDetail;
import com.book.pojo.BusDetail;

@Service
public class SearchImpl implements SearchBus {
	@Autowired
	private BusRepository busRepository;
	@Autowired
	private EntityManager entity;

	@Override
	public List<BusDetail> search(String source, String destination, String travelDate) {
		List<BusDetail> detail = new ArrayList<BusDetail>();
		detail = busRepository.findBySouceCityAndDestinationCityAndTravelDate(source, destination, travelDate);
		return detail;

	}

	@Transactional(timeout = 120)
	@Override
	public synchronized String bookSeat(String busNo, String seat, String travelDate, int journeyId, double price) {
		List<BookingDetail> detail = new ArrayList<BookingDetail>();
		detail = busRepository.checkBookExist(busNo, seat, travelDate);
		if (detail.isEmpty()) {
			BookingDetail bookingDetail = new BookingDetail();
			BusDetail busdetail = new BusDetail();
			bookingDetail.setBusNo(busNo);
			bookingDetail.setSeatNo(seat);
			bookingDetail.setJournyDate(travelDate);
			busdetail.setJournyId(journeyId);
			bookingDetail.setBusdetail(busdetail);
			bookingDetail.setBookinfPrice(price + (price * 0.1));
			entity.merge(bookingDetail);
			return "Booking successful for same seat";
		} else {
			return "Booking already exists for same seat";
		}
	}

	@Override
	public List<BookingDetail> getOccupiedSeat(String busNo, String travelDate) {
		List<BookingDetail> detail = new ArrayList<BookingDetail>();
		detail = busRepository.findByBusNoAndTravelDate(busNo, travelDate);
		return detail;
	}

	@Override
	public List<String> getTotalList() {
		List<String> detail = new ArrayList<String>();
		detail = busRepository.findTotalSeat();
		return detail;
	}

}
