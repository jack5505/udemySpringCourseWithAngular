package com.example.bank.demo.modells;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class SavingsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String name;
    private Date date;
    private String description;
    private String location;

    @ManyToOne
    @JoinColumn(name = "savings_account_id")
    private SavingsAccount savingsAccount;

}
