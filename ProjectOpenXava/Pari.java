package com.yourcompany.project_bmo_lelioalex.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Pari {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    int id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Column(length=50)
    @Required
    String typeDePari;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="utilisateur_id") // Le nom de la colonne dans la table des Pari qui référence l'utilisateur
    @Required
    Utilisateur utilisateur;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Column(length=50)
    @Required
    String evenement;
    
    @Money
    @Required
    BigDecimal montantMisé;
    
    @Column(length=10)
    @Required
    String resultatPrevu;

}

