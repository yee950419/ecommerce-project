package com.ecommerse.user_service.user.controller;

import com.ecommerse.user_service.user.dto.UserDto;
import com.ecommerse.user_service.user.service.UserService;
import com.ecommerse.user_service.user.vo.Greeting;
import com.ecommerse.user_service.user.vo.RequestUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {

        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {

        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody RequestUser requestUser) {

        UserDto userDto = UserDto.builder()
                .email(requestUser.getEmail())
                .name(requestUser.getName())
                .password(requestUser.getPassword())
                .build();

        userService.createUser(userDto);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
