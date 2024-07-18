package com.example.second_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/second-service")
public class TestController {

    @GetMapping("/welcome")
    public String test() {

        return "second-service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-request") String header) {

        log.info("header = " + header);
        return "second-service message called";
    }

    @GetMapping("/check")
    public String check() {
        return "this is second-service message";
    }
}
