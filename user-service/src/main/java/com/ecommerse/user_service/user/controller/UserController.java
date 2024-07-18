package com.ecommerse.user_service.user.controller;

import com.ecommerse.user_service.user.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    private final Greeting greeting;

    @GetMapping("/health_check")
    public String status() {

        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {

        return greeting.getMessage();
    }
}
