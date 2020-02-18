package com.example.bank.demo.services;

import com.example.bank.demo.modells.PrimaryAccount;
import com.example.bank.demo.modells.SavingsAccount;

public interface AccountService {
    PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();

}
