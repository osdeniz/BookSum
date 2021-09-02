package com.Book.service;

import com.Book.entity.BookEntity;
import com.Book.model.dto.BookDto;

import java.util.List;

public interface IBookService {

     List<BookEntity> getAllList();

     BookEntity createOrUpdate(BookDto bookDto);

     String deleteById(Long id);



/*
     List<Book> getList();

     Book create(Book book);

     Book update(Book book);

     String delete(Integer id);
*/


}
