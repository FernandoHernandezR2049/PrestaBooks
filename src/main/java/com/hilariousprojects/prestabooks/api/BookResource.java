package com.hilariousprojects.prestabooks.api;

import com.hilariousprojects.prestabooks.domain.Book;
import com.hilariousprojects.prestabooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookResource {
    private final BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<List<Book>>getBooks(){
        return ResponseEntity.ok().body(bookService.getBooks());
    }
    @PostMapping("/book")
    public ResponseEntity<Book>saveBook(@RequestBody Book book){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/book").toUriString());
        return ResponseEntity.created(uri).body(bookService.saveBook(book));
    }
    @PutMapping("/book/{id}")
    public ResponseEntity<Book>updateBook(@RequestBody Book book,@PathVariable Long id){
        return ResponseEntity.ok().body(bookService.updateBook(book,id));
    }
}
