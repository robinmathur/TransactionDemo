package com.rob.service;

import com.rob.model.User;

/**
 * Created by robinmathur on 03/03/17.
 */
public interface UserService {
    public User getUser(long userID);
    public  void saveUser(User user);
}
