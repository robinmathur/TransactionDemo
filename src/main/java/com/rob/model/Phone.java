package com.rob.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by robinmathur on 08/03/17.
 */
@Entity
@Table(name = "PHONE")
public class Phone implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "PHONE_ID")
    private long phoneId;

    @Enumerated(EnumType.STRING)
    private PhoneModel phoneModel;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;


    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
    }

    public PhoneModel getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(PhoneModel phoneModel) {
        this.phoneModel = phoneModel;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
