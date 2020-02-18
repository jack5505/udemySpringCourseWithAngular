package com.example.bank.demo.services;

import com.example.bank.demo.modells.User;
import com.example.bank.demo.modells.security.UserRole;
import com.example.bank.demo.repository.RoleRepository;
import com.example.bank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private AccountService accountService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean checkUserExists(String username, String password) {
        return userRepository.findByUsernameOrEmail(username,password) == null ? false : true;
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

    @Override
    public User createUser(User user, Set<UserRole> userRoleSet) {
        User localUser  = userRepository.findByUsername(user.getUsername());
        if(localUser == null){
            String encrypted = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encrypted);

            for(UserRole i : userRoleSet){
                roleRepository.save(i.getRole());
            }
            user.getUserRoleSet().addAll(userRoleSet);

            user.setPrimaryAccount(accountService.createPrimaryAccount());
            user.setSavingsAccount(accountService.createSavingsAccount());
         //   localUser = userRepository.save(user);
        }
        return localUser;
    }


}
