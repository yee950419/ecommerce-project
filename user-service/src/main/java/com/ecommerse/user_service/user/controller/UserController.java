package com.ecommerse.user_service.user.controller;

import com.ecommerse.user_service.user.dto.UserDto;
import com.ecommerse.user_service.user.service.UserService;
import com.ecommerse.user_service.user.vo.Greeting;
import com.ecommerse.user_service.user.vo.RequestUser;
import com.ecommerse.user_service.user.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-service")
public class UserController {

    private final Greeting greeting;
    private final UserService userService;
    private final Environment env;

    @GetMapping("/health_check")
    public String status() {

        return String.format("It's Working in User Service on PORT %s", env.getProperty("local.server.port"));
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

        ResponseUser responseUser = userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }
}
