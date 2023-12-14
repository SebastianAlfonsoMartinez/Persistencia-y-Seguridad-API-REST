package com.apirestmongo.persistenciayseguridadapirest.domain.repository;

import com.apirestmongo.persistenciayseguridadapirest.domain.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
