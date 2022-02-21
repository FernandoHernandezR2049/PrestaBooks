package com.hilariousprojects.prestabooks.service;

import com.hilariousprojects.prestabooks.domain.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    Book getBook(String bookTitle);
    List<Book> getBooks();
    Book updateBook(Book book, Long id);
    void deleteBook(Long id);

}
