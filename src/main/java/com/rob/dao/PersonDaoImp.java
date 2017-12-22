package com.rob.dao;

import com.rob.dao.dto.PERSON_DTO;
import com.rob.model.Person;
import com.rob.model.User;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by robinmathur on 23/10/16.
 */
@Repository("personDao")
public class PersonDaoImp implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session = null;

    public Person getPerson(long id) {
//        Person p = (Person) sessionFactory.getCurrentSession().get(Person.class,id);
        Query query = sessionFactory.getCurrentSession().getNamedQuery("HQL_GET_ALL_PERSON").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Person> personList = query.list();
//        List<Person> personList = (List<Person>) sessionFactory.getCurrentSession().getNamedQuery("GET_ALL_PERSON_NATIVE").setParameter("age",28).setReadOnly(true).list();
//        List<PERSON_DTO> personList = (List<PERSON_DTO>) sessionFactory.getCurrentSession().getNamedQuery("GET_ALL_PERSON_NATIVE").setReadOnly(true)
//                .setParameter("age",28).list();


//        DetachedCriteria userCriteria = DetachedCriteria.forClass(User.class, "user");
//        userCriteria.add(Restrictions.eq("name", "Robin"));
//        userCriteria.setProjection(Property.forName("name"));
//        userCriteria.add(Property.forName("user.personId").eqProperty(Property.forName("person.personId")));
//        Criterion ageCriterion = Restrictions.not(Restrictions.in("age",new Integer[]{35,26}));
//        Criterion nameCriterion = Restrictions.in("age", new Integer[]{25});
//        LogicalExpression ageNameLogicalExpression = Restrictions.or(ageCriterion, nameCriterion);
//        userCriteria.add(ageNameLogicalExpression);
//        Criteria personCriteria = sessionFactory.getCurrentSession().createCriteria(Person.class,"person");
//        personCriteria.addOrder(Order.asc("age")).addOrder(Order.asc("address"));
//        personCriteria.setProjection(Projections.property("name"));
//        personCriteria.setProjection(Property.forName("user.address"));
//        personCriteria.setResultTransformer(new ResultTransformer() {
//            public Object transformTuple(Object[] objects, String[] strings) {
//                return new Person((String)objects[0],null, 0);
//            }
//
//            public List transformList(List list) {
//                return list;
//            }
//        });
//        personCriteria.setResultTransformer(new ResultTransformer() {
//            public Object transformTuple(Object[] objects, String[] strings) {
//                return new PERSON_DTO((String)objects[0], (String) objects[1]);
//            }
//
//            public List transformList(List list) {
//                return list;
//            }
//        });
//        personCriteria.add(Property.forName("name").eq(userCriteria));
//        personCriteria.add(Subqueries.exists(userCriteria)).setComment("GET ALL THE PERSONS WITH ELIGIBILITY");
//        List<Person> personList = personCriteria.setCacheable(true).setCacheRegion("query.person.getall").list();
//        List<PERSON_DTO> personList = personCriteria.list();
//
//
        for(Person person : personList){
            System.out.println(person);
//            person.removePhone(person.getPhoneList().get(1));
//            person.setName("Changed");
        }
//        System.out.println("---------------");
//        sessionFactory.getCache().evictQueryRegion("query.person.getall");
//        personCriteria.setCacheMode(CacheMode.IGNORE);
//        personCriteria.list();
//        personCriteria.setCacheMode(CacheMode.GET);
//        System.out.println("---------------");
//        personCriteria.list();


        return new Person();
    }

    public void savePerson(Person person) {
        session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public void updatePerson(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
    }

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        throw new NullPointerException("");
    }
}
