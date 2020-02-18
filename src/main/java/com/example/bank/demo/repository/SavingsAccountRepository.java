package com.example.bank.demo.repository;

import com.example.bank.demo.modells.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountRepository extends JpaRepository<SavingsAccount,Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}
