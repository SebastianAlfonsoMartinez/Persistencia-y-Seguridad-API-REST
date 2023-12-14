package com.apirestmongo.persistenciayseguridadapirest.controller;

import com.apirestmongo.persistenciayseguridadapirest.domain.dto.UserDto;
import com.apirestmongo.persistenciayseguridadapirest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(
        UserService userService
) {

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<?> searchAll() {
        return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")

        public ResponseEntity<?> deleteUser (@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
