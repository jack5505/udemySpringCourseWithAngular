package com.example.bank.demo.modells;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Reciepent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  name;
    private String email;
    private String  phone;
    private String  accountNumber;
    private String  description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;




}
