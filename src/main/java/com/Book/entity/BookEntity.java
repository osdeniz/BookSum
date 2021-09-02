package com.Book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BOOK_TABLE")
public class BookEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)//auto işlemi springbooot web sitesinden çekitk otomatik ıd atıyor
    @Column(name = "Id")
    private Long id;

    @Column (name="TITLE")
    private String title;

    @Column (name="DESCRIPTION")
    private String description;

    @Column (name="CREATEDATE")
    private Date createDate;

    @Lob
    @Column (name="BOOKDETAILS")
    private String bookDetails;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public String getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(String bookDetails) {
        this.bookDetails = bookDetails;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}