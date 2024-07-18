package com.ecommerse.user_service.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String email;
    private String name;
    private String password;
    private String userId;
    private Date createdAt;

    private String encryptedPassword;

    @Builder
    public UserDto(String email, String name, String password) {

        this.email = email;
        this.name = name;
        this.password = password;
    }
}
