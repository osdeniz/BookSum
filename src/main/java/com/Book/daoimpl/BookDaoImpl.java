package com.Book.daoimpl;

import com.Book.dao.IBookDao;
import com.Book.entity.BookEntity;
import com.Book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl implements IBookDao {

    @Autowired
    private IBookRepository repository;

    @Override
    public List<BookEntity> getAllList() {//bu işlem arkada bşze selecet*from tüm dataları çağırıyor
        List<BookEntity> list = repository.findAll();
        return list;

    }

    @Override
    public BookEntity createOrUpdate(BookEntity bookEntity) {
        return repository.save(bookEntity);
    }

    @Override
    public BookEntity getById(Long id) {

        repository.findById(id).get();
        return null;
    }

    @Override
    public int removeById(Long id) {
        repository.deleteById(id);
        return 1;
    }





 /*   private static List<Book> books = new ArrayList<>(); bu kısımları iptal ettik çünkü mysqp bağlantısı olmadığı için kendimi yaratmıştık
    private static int i = 0;

    @Override
    public List<Book> getList() {
        return books;
    }

    @Override
    public Book create(Book book) {
        i++;
        book.setId(i);
        books.add(book);//arreyin ıd li halini burdan görmüş olcaz
        return book;


    }

    @Override
    public Book update(Book book) {
        for (Book item:books){
            if(item.getId() == book.getId()){
                item.setTitle(book.getTitle());
                item.setDescription(book.getDescription());
                item.setList(book.getList());
                item.setLastModifiedDate(book.getLastModifiedDate());
            }
        }
        return book;
    }

    @Override
    public int delete(Integer id) {
        int index = -1;

        for (int i=0 ;i<books.size();i++){
            if(books.get(i).getId() == id){
                index = i;
                break;
            }
        }
        if(index != -1){
            books.remove(index);
            return 1;
        }
        return 0;
    }*/
}
