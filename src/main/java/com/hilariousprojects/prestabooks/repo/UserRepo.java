package com.hilariousprojects.prestabooks.repo;

import com.hilariousprojects.prestabooks.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
