package com.apirestmongo.persistenciayseguridadapirest.controller;

import com.apirestmongo.persistenciayseguridadapirest.domain.dto.BookingDto;
import com.apirestmongo.persistenciayseguridadapirest.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booking")
public record BookingController(
        BookingService bookingService
) {
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingDto bookingDto){
        bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> searchAll(){return new ResponseEntity<>(bookingService.findAll(),
            HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchBooking(@PathVariable("id") String id) {
        return new  ResponseEntity<>(bookingService.findBookingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") String id) {
        bookingService.deleteBooking(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBooking(@RequestBody BookingDto bookingDto){
        bookingService.updateBooking(bookingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
