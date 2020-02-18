package com.example.bank.demo.repository;

import com.example.bank.demo.modells.PrimaryAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryAccountRepository extends JpaRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber(int accountNumber);
}
