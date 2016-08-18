package org.bhc.persistance.models;

import javax.persistence.*;
import java.util.Date;

/**
 * A POJO to represent a walk/hike
 */
@Entity
public class Walk {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "WALKDATE")
    private Date walkDate;

    /**
     * Default constructor for an empty walk object
     */
    public Walk() {
        this.name = "";
        this.description = "";
    }

    /**
     * Create a basic walk object
     * @param name The name of the walk
     * @param description A meaningful description of the walk
     */
    public Walk(String name, String description){
        this.name = name;
        this.description = description;
        this.walkDate = new Date();
    }

    /**
     * Create a full walk object
     * @param name The name of the walk
     * @param description A meaningful description of the walk
     * @param walkDate The date on which the walk will take place
     */
    public Walk(String name, String description, Date walkDate){
        this.name = name;
        this.description = description;
        this.walkDate = walkDate;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getWalkDate() {
        return walkDate;
    }

    public void setWalkDate(Date walkDate) {
        this.walkDate = walkDate;
    }
}
