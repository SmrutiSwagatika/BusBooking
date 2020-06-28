package com.book.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.book.pojo.BookingDetail;
import com.book.pojo.BusDetail;

@Repository
public interface BusRepository extends JpaRepository<BusDetail, String> {
	@Transactional
	@Query("SELECT bus FROM BusDetail bus  WHERE bus.sourceCity=:sourceCity AND bus.destinationCity=:destinationCity AND bus.travelDate=:travelDate Order By bus.price ASC ")
	List<BusDetail> findBySouceCityAndDestinationCityAndTravelDate(@Param("sourceCity") String sourceCity,
			@Param("destinationCity") String destinationCity, @Param("travelDate") String travelDate);

	@Transactional
	@Query("SELECT book FROM BookingDetail book  WHERE book.busNo=:busNo AND book.journyDate=:journyDate")
	List<BookingDetail> findByBusNoAndTravelDate(@Param("busNo") String busNo, @Param("journyDate") String journyDate);

	@Transactional
	@Query("SELECT seat.seatName FROM SeatDetail seat")
	List<String> findTotalSeat();

	@Transactional
	@Query("SELECT book FROM BookingDetail book  WHERE book.busNo=:busNo AND book.seatNo=:seatNo AND book.journyDate=:journyDate")
	List<BookingDetail> checkBookExist(@Param("busNo") String busNo, @Param("seatNo") String seatNo,
			@Param("journyDate") String journyDate);

}
