package com.ecommerse.user_service.user.service;

import com.ecommerse.user_service.user.dto.UserDto;
import com.ecommerse.user_service.user.vo.ResponseUser;

public interface UserService {

    ResponseUser createUser(UserDto userDto);

}
