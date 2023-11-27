package com.alibou.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String dateNaiss;
    private String lieuNaiss;
    private String numTel;
    private String numTuteur;
    private String nomTuteur;
    private String lieuResidence;
    private String regionOrigine;
    private Boolean statut = true;

//    @OneToMany(mappedBy = "customer")
//    private List<Payment> payments = new ArrayList<>();

}
