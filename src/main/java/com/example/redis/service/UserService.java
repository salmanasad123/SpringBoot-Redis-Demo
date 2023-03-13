package com.example.redis.service;

import com.example.redis.model.User;

import java.util.List;

public interface UserService {

    public boolean saveUser(User user);

    List<User> fetchAllUser();
}
