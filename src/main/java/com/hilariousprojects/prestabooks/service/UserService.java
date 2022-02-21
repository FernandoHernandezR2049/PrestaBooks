package com.hilariousprojects.prestabooks.service;

import com.hilariousprojects.prestabooks.domain.Role;
import com.hilariousprojects.prestabooks.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    void lendBook(String username, Long bookId);
    void returnBook(String username, Long bookId);
    User getUser(String username);
    List<User>getUsers();
}
