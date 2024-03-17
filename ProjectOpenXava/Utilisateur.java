package com.yourcompany.project_bmo_lelioalex.model;
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Utilisateur {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    int utilisateurId;

	@Column(length=50)
	String username;
	
}
