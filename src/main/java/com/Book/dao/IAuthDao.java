package com.Book.dao;

import com.Book.entity.UserEntity;

public interface IAuthDao {

    UserEntity register(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    UserEntity getByUserId(Long id);

    int removeById(Long id);


}
