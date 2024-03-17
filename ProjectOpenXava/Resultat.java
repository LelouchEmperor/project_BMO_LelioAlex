package com.yourcompany.project_bmo_lelioalex.model;
import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

public class Resultat {

    @Id
    @Hidden
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String ResultatId;
    
    @Column(length=50)
    @Required
    Integer evenementId;

    @Column(length=50)
    @Required
    String score;
}
