package com.Book.repository;

import com.Book.entity.BookEntity;
import org.springframework.data.repository.CrudRepository; //bu yapı basit crud işlemlerinin hepsini gerçekleştirebiliyor

import java.util.List;

public interface IBookRepository extends CrudRepository<BookEntity, Long> {
    List<BookEntity> findAll();

}