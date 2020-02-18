package com.example.bank.demo.init;

import com.example.bank.demo.modells.PrimaryAccount;
import com.example.bank.demo.modells.security.Role;
import com.example.bank.demo.modells.security.UserRole;
import com.example.bank.demo.repository.PrimaryAccountRepository;
import com.example.bank.demo.repository.RoleRepository;
import com.example.bank.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userService.checkUsernameExists("jack"));
      //  primaryAccountRepository.findByAccountNumber(43092456);
        if(roleRepository.count() == 0){
            roleRepository.save(new Role(1,"ROLE_USER"));
        }

    }
}
