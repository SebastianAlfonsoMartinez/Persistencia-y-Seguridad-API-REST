package com.apirestmongo.persistenciayseguridadapirest.service;

import com.apirestmongo.persistenciayseguridadapirest.domain.dto.BookingDto;
import com.apirestmongo.persistenciayseguridadapirest.domain.entity.Booking;
import com.apirestmongo.persistenciayseguridadapirest.domain.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record BookingService(
        BookingRepository bookingRepository
) {

    public void createBooking(BookingDto bookingDto){
        Booking booking = Booking.builder()
                .state(bookingDto.state())
                .quantity(bookingDto.quantity())
                .build();
        bookingRepository.save(booking);
    }

    public List<Booking> findAll(){return bookingRepository.findAll();}

    public void deleteBooking(String id){
       Booking booking = bookingRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
       bookingRepository.delete(booking);
    }

    public Booking findBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
    }

    public void updateBooking(BookingDto bookingDto){
        Booking booking = bookingRepository.findById(bookingDto.id())
                .orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        updateBookingDate(booking, bookingDto);
        bookingRepository.save(booking);
    }

    private void updateBookingDate(Booking booking, BookingDto bookingDto) {

        booking.setUser(bookingDto.user());
        booking.setState(bookingDto.state());
        booking.setQuantity(bookingDto.quantity());

    }


}
