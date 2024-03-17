package com.yourcompany.project_bmo_lelioalex.model;
import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Compte {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    int compteId;

	@Column(length=50)
	String email;
	
	@Column(length=50)
	String motDePasse;
	
	@Column(length=50)
	int nombreDeJetons;
	
	
	
	@OneToOne(
			fetch=FetchType.LAZY,
			optional=true)
	Utilisateur utilisateur;
}
