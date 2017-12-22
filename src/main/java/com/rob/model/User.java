package com.rob.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by robinmathur on 23/10/16.
 */
@Entity
@Table(name = "USER")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private long personId;
    @Column(name="NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "AGE")
    private int age;

    public User(){
    }

    public User(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }



    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
