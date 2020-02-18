package com.example.bank.demo.services.impl;

import com.example.bank.demo.modells.PrimaryAccount;
import com.example.bank.demo.modells.SavingsAccount;
import com.example.bank.demo.repository.PrimaryAccountRepository;
import com.example.bank.demo.repository.SavingsAccountRepository;
import com.example.bank.demo.services.AccountService;
import com.example.bank.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private PrimaryAccountRepository primaryAccountRepository;

    @Autowired
    private SavingsAccountRepository savingsAccountRepository;


    @Autowired
    private UserService userService;

    private static int nextAccountNumber = 11223145;

    @Override
    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountRepository.save(primaryAccount);

        return primaryAccountRepository.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    private int accountGen() {

            return ++nextAccountNumber;
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());
        savingsAccountRepository.save(savingsAccount);
        return savingsAccountRepository.findByAccountNumber(savingsAccount.getAccountNumber());
    }
}
