package com.Book.repository;

import com.Book.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<UserEntity, Long> {
}
