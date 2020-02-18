package com.example.bank.demo.services;

import com.example.bank.demo.modells.User;
import com.example.bank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkUserExists(String username, String password) {
        return userRepository.findByUsernameAndEmail(username,password) == null ? false : true;
    }

    @Override
    public boolean checkEmailExists(String email) {
        return userRepository.findByEmail(email) == null ? false : true;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return userRepository.findByUsername(username) == null ? false : true;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
