package com.Book.serviceimpl;

import com.Book.dao.IAuthDao;
import com.Book.dao.IBookDao;
import com.Book.entity.BookEntity;
import com.Book.entity.UserEntity;
import com.Book.model.dto.BookDto;
import com.Book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service //extend aldığı yer component
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Autowired
    private IAuthDao authDao;

    @Override
    public List<BookEntity> getAllList() {
        return bookDao.getAllList();
    }

    @Override
    public BookEntity createOrUpdate(BookDto bookDto) {
        BookEntity bookEntity = null;
        //bir logic yapıcaz gelen obje içerisinde id varmı id si null mı eğer nulldan fakrlıysa içi doludur.
        if (bookDto.getId() != null){
            bookEntity = bookDao.getById(bookDto.getId());
        }else{
            bookEntity = new BookEntity();
            bookEntity.setCreateDate(new Date());
        }
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setBookDetails(bookDto.getBookDetails());
        UserEntity currentUser = authDao.getByUserId(bookDto.getUserId());

        bookEntity.setUser(currentUser);



        return bookDao.createOrUpdate(bookEntity);
    }

    @Override
    public String deleteById(Long id) {
        int result = bookDao.removeById(id);

        return result == 1 ? "İşlem başarılı." : "İşlem başarısız." ;
    }

    /*@Override
    public List<Book> getList() {
        return bookDao.getList();
    }

    @Override
    public Book create(Book book) {
        Date newDate = new Date();
        String pattern = "MM-dd-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        book.setCreateDate(date);
        return bookDao.create(book);
    }

    @Override
    public Book update(Book book) {
        Date newDate = new Date();
        String pattern = "MM-dd-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(newDate);
        book.setLastModifiedDate(date);
        return bookDao.update(book);
    }

    @Override
    public String delete(Integer id) {

        int status = bookDao.delete(id);

        if(status == 1){
            return "İşlem başarılı.";
        }

        return "İşlem başarısız.";
    }*/
}
