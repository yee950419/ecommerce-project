package com.ecommerse.user_service.user.service;

import com.ecommerse.user_service.user.dto.UserDto;
import com.ecommerse.user_service.user.entity.User;
import com.ecommerse.user_service.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());

        User newUser = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .userId(userDto.getUserId())
                .build();

        newUser.setEncryptedPassword("encrypted_password");

        userRepository.save(newUser);

        return null;
    }
}
