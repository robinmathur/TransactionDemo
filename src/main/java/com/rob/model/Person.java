package com.rob.model;

import com.rob.dao.dto.PERSON_DTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by robinmathur on 23/10/16.
 */
@Entity
@Table(name = "PERSON")
@NamedQueries(value = {@NamedQuery(name = "GET_ALL_PERSON", query = "select p from Person p join p.addresses")})
@NamedNativeQueries(value = {@NamedNativeQuery(name = "GET_ALL_PERSON_NATIVE",query = "select p.name as perName from person p where p.age=:age"
    ,resultSetMapping = "PERSON_DTO")})
@SqlResultSetMapping(name = "PERSON_DTO", classes = @ConstructorResult(targetClass = PERSON_DTO.class
        , columns = @ColumnResult(name = "perName")))
public class Person implements Serializable{
    @Id
    @GeneratedValue()
    @Column(name = "PERSON_ID")
    private long personId;
    @Column(name="NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "AGE")
    private int age;
    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    //    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "PERSON_ID")

    @ElementCollection
    @CollectionTable(name = "PERSON_ADDRESS",joinColumns = {@JoinColumn(name = "PERSON_FK")})
    List<Address> addresses = new ArrayList<Address>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "person")
    private List<Phone> phoneList = new ArrayList<Phone>();


//    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name = "PHONE_IDK")
//    private Phone phone;

    @Version
    private int version;

    public Person() {
    }

    public Person(String name, String address, int age) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void addPhone(Phone phone){
        phone.setPerson(this);
        getPhoneList().add(phone);
    }

    public void removePhone(Phone phone){
        phone.setPerson(null);
        getPhoneList().remove(phone);
    }

  /*  public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }*/

    public void addAddress(Address address){
        getAddresses().add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", addresses=" + addresses +
                ", phoneList=" + phoneList +
                ", version=" + version +
                '}';
    }
}
