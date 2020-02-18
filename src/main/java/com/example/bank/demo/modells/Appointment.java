package com.example.bank.demo.modells;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String  location;
    private String description;
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
