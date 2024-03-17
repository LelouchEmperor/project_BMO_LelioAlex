package com.yourcompany.clubsportif.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class TypeDePari {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    int id;
    
    
    @OneToMany(fetch=FetchType.LAZY,
    		optional=false)
            Pari pari;
    

    @Column(length=50)
    @Required
    String description;
    
}

