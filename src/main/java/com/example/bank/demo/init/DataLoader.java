package com.example.bank.demo.init;

import com.example.bank.demo.modells.PrimaryAccount;
import com.example.bank.demo.repository.PrimaryAccountRepository;
import com.example.bank.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.checkUsernameExists("jack"));
       // primaryAccountRepository.findByAccountNumber(11223146);

    }
}
