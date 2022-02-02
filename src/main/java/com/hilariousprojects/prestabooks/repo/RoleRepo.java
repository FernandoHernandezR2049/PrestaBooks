package com.hilariousprojects.prestabooks.repo;

import com.hilariousprojects.prestabooks.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
