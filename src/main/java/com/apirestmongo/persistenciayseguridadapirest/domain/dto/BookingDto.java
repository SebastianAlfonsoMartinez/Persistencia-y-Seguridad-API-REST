package com.apirestmongo.persistenciayseguridadapirest.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.DBRef;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDto(
        String id,
        String state,
        Integer quantity,
        User user
) {
}
