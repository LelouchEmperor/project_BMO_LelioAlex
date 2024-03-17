package com.yourcompany.project_bmo_lelioalex.model;
import java.time.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Evenement {

	@Id
	@Hidden
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(length=32)
	String evenementId;
	
	@Column(length=50)
	@Required
	String Nom;
	
    @Required
    LocalDate date;
    
    @OneToOne(
			fetch=FetchType.LAZY,
			optional=true)
	TypeDeSport typeDeSport;

}
