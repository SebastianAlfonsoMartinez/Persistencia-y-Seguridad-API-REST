package com.apirestmongo.persistenciayseguridadapirest.service;

import com.apirestmongo.persistenciayseguridadapirest.domain.dto.UserDto;
import com.apirestmongo.persistenciayseguridadapirest.domain.entity.User;
import com.apirestmongo.persistenciayseguridadapirest.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public record UserService(
        UserRepository userRepository
) {

    public void createUser(UserDto userDto){
        User user = User.builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .age(userDto.age())
                .email(userDto.email())
                .build();
        userRepository.save(user);
    }


    public List<User> userList(){
        return userRepository.findAll();
    }

    public User findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
        userRepository.delete(user);
    }

    public void updateUser(UserDto userDto){
        User user = userRepository.findById(userDto.id())
                .orElseThrow(() -> new RuntimeException("Doctor not found..."));
        updateUserData(user, userDto);
        userRepository.save(user);
    }

    public void updateUserData(User user, UserDto userDto){
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setAge(userDto.age());
        user.setEmail(userDto.email());
    }

}
