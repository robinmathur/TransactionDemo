package com.rob;

import com.rob.model.Address;
import com.rob.model.Person;
import com.rob.model.Phone;
import com.rob.model.PhoneModel;
import com.rob.service.PersonService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by robinmathur on 23/10/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PersonTest {

    @Autowired
    private PersonService personService;

    @Test
//    @Ignore
    public void savePerson(){
        Person person = new Person("Roberin","Noiewrda",25);
        person.setDateOfBirth(new Date());
        Address address =new Address("Hisewrar");
        person.addAddress(address);
        Phone phone = new Phone();
        phone.setPhoneModel(PhoneModel.APPLE);
        Phone phone2 = new Phone();
        phone2.setPhoneModel(PhoneModel.NOKIA);
        person.addPhone(phone);
        person.addPhone(phone2);
        personService.savePerson(person);



    }
    @Test
//    @Ignore
    public void testGetPerson(){
        Person person = personService.getPerson(1);
//        person.getAddresses().get(1).getCity();

    }

    @Test
    @Ignore
    public void testUpdatePerson() {
        Person person = personService.getPerson(1);
        person.setName("UpdateName");
        personService.updatePerson(person);
    }
}
