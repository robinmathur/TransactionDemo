package com.rob.dao.dto;

/**
 * Created by robinmathur on 06/03/17.
 */
public class PERSON_DTO {

    private String personName;

    private String address;

    public PERSON_DTO(){}


    public PERSON_DTO(String personName, String address){
        this.personName =personName;
        this.address = address;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PERSON_DTO{" +
                "personName='" + personName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
