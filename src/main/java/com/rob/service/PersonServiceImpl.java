package com.rob.service;

import com.rob.dao.PersonDao;
import com.rob.model.Person;
import com.rob.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by robinmathur on 23/10/16.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    UserService userService;

//    @Transactional(readOnly = true)
    public Person getPerson(long id) {
        return personDao.getPerson(id);
    }

    public void savePerson(Person person) {
        userService.saveUser(new User("Bhola","Noida", 35));
        personDao.savePerson(person);
    }
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    public void saveUser(User user) {
        personDao.saveUser(user);
    }
}


