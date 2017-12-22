package com.rob.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robinmathur on 07/01/17.
 */
@Embeddable
public class Address implements Serializable {

//    @Id
//    @Column(name = "ADDRESS_ID")
//    @GeneratedValue
//    private int id;

    @Column(name = "CITY")
    private String city;

//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
//    private Person person;

    public Address(){}

    public Address(String city){
        this.city=city;
//        this.person=person;
    }

//    public int getId() {
//        return id;
//    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
