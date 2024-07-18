package com.example.first_service.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/first-service")
public class TestController {

    private final Environment env;

    @GetMapping("/welcome")
    public String test() {

        return "first-service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {

        log.info("header = " + header);
        return "first-service message called";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {

        log.info("server port = {}", request.getServerPort());

        return "this is first-service message on port " + env.getProperty("local.server.port");
    }
}
