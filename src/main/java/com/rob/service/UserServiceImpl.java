package com.rob.service;

import com.rob.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by robinmathur on 03/03/17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public User getUser(long userID) {
        return (User)sessionFactory.getCurrentSession().get(User.class, userID);
    }

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}