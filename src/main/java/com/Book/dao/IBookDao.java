package com.Book.dao;

import com.Book.entity.BookEntity;

import java.util.List;

public interface IBookDao {

    List<BookEntity> getAllList();

    BookEntity createOrUpdate(BookEntity bookEntity);

    BookEntity getById(Long id);

    int removeById(Long id);

/*    List<Book> getList(); buralarıda sildik bookdaodakkki sebepten dolayı mysqp bağalnatımız olduğu için fakrlın kodlar yazacağız

    //id null
    Book create(Book book);
    //id var
    Book update(Book book);

    int delete(Integer id);*/
    
}
