package com.rob.service;

import com.rob.model.Person;
import com.rob.model.User;

/**
 * Created by robinmathur on 23/10/16.
 */
public interface PersonService {

    public Person getPerson(long id);
    public void savePerson(Person person);
    public void updatePerson(Person person);
    public  void saveUser(User user);

}
