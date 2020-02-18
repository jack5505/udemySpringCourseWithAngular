package com.example.bank.demo.services;

import com.example.bank.demo.modells.User;
import com.example.bank.demo.modells.security.UserRole;

import java.util.Set;

public interface UserService {
    boolean checkUserExists(String username,String password);

    boolean checkEmailExists(String email);

    boolean checkUsernameExists(String username);

    void save(User user);


    User createUser(User user, Set<UserRole> userRoleSet);
}
