package com.manning.readinglist.pojo;

import javax.persistence.*;

/**
 * @author jrl
 * @date Create in 14:46 2022-2-16
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Book() {
    }

    public Book(Long id, String reader, String isbn, String title, String author, String description) {
        this.id = id;
        this.reader = reader;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Book(String isbn, String title, String author, String description) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
