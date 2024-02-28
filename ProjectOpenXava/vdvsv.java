package com.yourcompany.clubsportif.model;

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
    
    
    @OneToOne(fetch=FetchType.LAZY,
    		optional=false)
    TypePari typePari;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="utilisateur_id") // Le nom de la colonne dans la table des Pari qui référence l'utilisateur
    Utilisateur utilisateur;
    
    @OneToOne(fetch=FetchType.LAZY)
    Evenement evenement;
    
    @Money
    BigDecimal montantMisé;
    
   
    
    
 // Ajoutez une méthode ou une annotation pour rendre les champs conditionnels
    @Depends("typePari")
    public boolean isResultatPrevuVisible() {
        // Renvoie vrai si le champ resultatPrevu doit être visible en fonction du type de pari sélectionné
        // Vous pouvez mettre en place ici la logique pour déterminer la visibilité du champ en fonction du type de pari
        // Par exemple, si le type de pari est "simple", le champ resultatPrevu peut être caché
        return !typePari.getNom().equals("Simple");
    }

}

