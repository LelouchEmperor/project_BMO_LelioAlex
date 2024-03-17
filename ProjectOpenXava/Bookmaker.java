package com.yourcompany.project_bmo_lelioalex.model;
import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Bookmaker {
	
	@Id
	@Hidden
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	String bookmakerId;
	
	@Column(length=50)
	@Required
	String Nom;

	@Column(length=50)
	@Required
	String Prenom;

}
	



