package com.apirestmongo.persistenciayseguridadapirest.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserDto(

        Integer id,
        String firstName,
        String lastName,
        Integer age,
        String email

) {


}
