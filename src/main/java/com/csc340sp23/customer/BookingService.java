package com.csc340sp23.customer;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hilda
 */
@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    
    public Booking getBookingById(Long id) {

        return bookingRepository.getReferenceById(id);

    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);
    }
   
  
   public boolean isAvailable(LocalDate checkInDate, LocalDate checkOutDate, List<Booking> bookings) {
    for (Booking booking : bookings) {
        if (checkInDate.isBefore(booking.getCheckOutDate()) && checkOutDate.isAfter(booking.getCheckInDate())) {
            return false; // Room is already booked during this period
        }
    }
    return true; // Room is available during this period
}

 
}
