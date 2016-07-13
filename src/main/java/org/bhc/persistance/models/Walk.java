package org.bhc.persistance.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Walk {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    public String name;
    private String description;
    private Date walkDate;

    public Walk(String name, String description){
        this.name = name;
        this.description = description;
    }
}
