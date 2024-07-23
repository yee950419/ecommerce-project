package com.ecommerse.user_service.user.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseUser {

    private String email;
    private String name;
    private String userId;
}
