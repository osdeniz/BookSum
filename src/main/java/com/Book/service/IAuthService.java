package com.Book.service;

import com.Book.entity.UserEntity;
import com.Book.model.dto.UserDto;

public interface IAuthService {

    UserEntity create(UserDto userDto);

    UserEntity update(UserDto userDto) throws Exception;

    UserEntity getById(Long id);

    String removeUser(Long id);

}
