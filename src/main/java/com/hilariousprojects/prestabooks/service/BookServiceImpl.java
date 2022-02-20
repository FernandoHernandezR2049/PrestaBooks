package com.hilariousprojects.prestabooks.service;

import com.hilariousprojects.prestabooks.domain.Book;
import com.hilariousprojects.prestabooks.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Slf4j @RequiredArgsConstructor
public class BookServiceImpl implements  BookService{
    private final BookRepo bookRepo;

    @Override
    public Book saveBook(Book book) {
        log.info("Saving new book {} in the database:", book.getTitle());
        return bookRepo.save(book);
    }

    @Override
    public Book getBook(String bookTitle) {
        return bookRepo.findByTitle(bookTitle);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

}
