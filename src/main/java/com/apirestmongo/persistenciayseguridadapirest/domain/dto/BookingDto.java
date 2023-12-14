package com.apirestmongo.persistenciayseguridadapirest.domain.dto;

import com.apirestmongo.persistenciayseguridadapirest.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookingDto(
        String id,
        String state,
        Integer quantity,
        User user
) {
}
