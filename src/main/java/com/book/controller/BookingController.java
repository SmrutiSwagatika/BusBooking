package com.book.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.book.pojo.BookingDetail;
import com.book.pojo.BusDetail;
import com.book.service.SearchBus;

@RestController
public class BookingController {
	@Autowired
	SearchBus searchBus;

	@GetMapping(value = "/getBusDetails/{source}/{destination}/{travelDate}")
	@ResponseBody
	public Map<Integer, Map<String, String>> getBusDetail(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("travelDate") String travelDate)
			throws ParseException {
		List<BusDetail> buses = searchBus.search(source, destination, travelDate);
		Map<Integer, Map<String, String>> map = new LinkedHashMap<Integer, Map<String, String>>();
		for (int i = 0; i < buses.size(); i++) {
			Map<String, String> map1 = new LinkedHashMap<String, String>();
			boolean f = true;
			while (f) {
				map1.put("JournyId", String.valueOf(buses.get(i).getJournyId()));
				map1.put("BusNumber", buses.get(i).getBusNo());
				map1.put("OperatorName", buses.get(i).getOperatorName());
				map1.put("SourceCity", buses.get(i).getSourceCity());
				map1.put("DestinationCity", buses.get(i).getDestinationCity());
				map1.put("DepatureTime",
						(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss")).format(buses.get(i).getDapartureTime()));
				map1.put("ArrivalTime",
						(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss")).format(buses.get(i).getArrivalTime()));
				map1.put("Price", String.valueOf(buses.get(i).getPrice()));
				f = false;
			}
			map.put(i, map1);

		}
		return map;
	}

	@GetMapping(value = "/getSeatDetail/{busNo}/{travelDate}")
	public Map<String, List<String>> getAvailableSeatDetail(@PathVariable("busNo") String busNo,
			@PathVariable("travelDate") String travelDate) throws ParseException {
		List<BookingDetail> seats = searchBus.getOccupiedSeat(busNo, travelDate);
		List<String> total = searchBus.getTotalList();
		List<String> seat = new ArrayList<String>();
		for (BookingDetail bookingDetail : seats) {
			seat.add(bookingDetail.getSeatNo());
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("Total seats", total);
		map.put("Reserver seats", seat);
		return map;
	}

	@GetMapping(value = "/booking/{busNo}/{seat}/{travelDate}/{journyId}/{bookinfPrice}")
	public String booking(@PathVariable("busNo") String busNo, @PathVariable("seat") String seat,
			@PathVariable("travelDate") String travelDate, @PathVariable("journyId") int journyId,
			@PathVariable("bookinfPrice") double bookinfPrice) throws ParseException {
		return searchBus.bookSeat(busNo, seat, travelDate, journyId, bookinfPrice);

	}

}
