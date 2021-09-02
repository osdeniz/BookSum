package com.Book.controller;

import com.Book.entity.BookEntity;
import com.Book.model.dto.BookDto;
import com.Book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces ="application/json")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "createOrUpdate", method = RequestMethod.POST)
    public BookEntity create(@RequestBody BookDto bookDto){
        return bookService.createOrUpdate(bookDto);
    }

    @RequestMapping(value = "allList", method = RequestMethod.GET)
    public List<BookEntity> getAllList(){
        return bookService.getAllList();

    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        return bookService.deleteById(id);
    }


   /* @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Book> getList(){

        return bookService.getList();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @RequestMapping(value ="update", method = RequestMethod.PUT)
    public Book update(@RequestBody Book book){
        return bookService.update(book);

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        return bookService.delete(id);

    }*/
}
