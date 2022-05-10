package com.hilariousprojects.prestabooks.service;

import com.hilariousprojects.prestabooks.domain.Book;
import com.hilariousprojects.prestabooks.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Book updateBook(Book book, Long id) {
        Book bookDB = bookRepo.findById(id).get();
        if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())){
            bookDB.setTitle(book.getTitle());
        }
        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())){
            bookDB.setAuthor(book.getAuthor());
        }
        if (Objects.nonNull(book.getIsbn()) && !"".equalsIgnoreCase(book.getIsbn())){
            bookDB.setIsbn(book.getIsbn());
        }

        return bookRepo.save(bookDB);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    @Override
    public Book lentBook(Long id) {
        Book bookDB = bookRepo.findById(id).get();
        bookDB.setState(1);
        return bookRepo.save(bookDB);
    }

    @Override
    public Book returnBook(Long id) {
        Book bookDB = bookRepo.findById(id).get();
        bookDB.setState(0);
        return bookRepo.save(bookDB);
    }

}
