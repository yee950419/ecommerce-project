package com.ecommerse.user_service.user.service;

import com.ecommerse.user_service.user.dto.UserDto;
import com.ecommerse.user_service.user.entity.User;
import com.ecommerse.user_service.user.repository.UserRepository;
import com.ecommerse.user_service.user.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseUser createUser(UserDto userDto) {

        userDto.setUserId(UUID.randomUUID().toString());

        User newUser = User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .userId(userDto.getUserId())
                .build();

        newUser.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        userRepository.save(newUser);

        ResponseUser responseUser = ResponseUser.builder()
                .email(newUser.getEmail())
                .name(newUser.getName())
                .userId(newUser.getUserId())
                .build();

        return responseUser;
    }

}
