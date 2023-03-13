package com.example.redis.repository;

import com.example.redis.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUser();
}
