package com.yourcompany.clubsportif.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class TypeDeSport {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    int sportTypeid;
    
    
    @Column(length=50)
    @Required
    String sporTypeName;
    

    @Column(length=50)
    @Required
    int nombrePeriode;
    
}

