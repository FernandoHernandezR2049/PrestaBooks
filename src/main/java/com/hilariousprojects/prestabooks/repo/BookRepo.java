package com.hilariousprojects.prestabooks.repo;

import com.hilariousprojects.prestabooks.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
