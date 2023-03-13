package com.example.redis.repository;

import com.example.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

// inside this repository we will store our data to redis
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // we need a key to hash
    private static final String key = "USER";


    @Override
    public boolean saveUser(User user) {

        try {
            redisTemplate.opsForHash()
                    .put(key, user.getId().toString(), user);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    @Override
    public List<User> fetchAllUser() {

        List<User> users;
        users = redisTemplate.opsForHash()
                .values(key)
                .stream()
                .map((Object user) -> {

                    User u = (User) user;
                    return u;
                }).collect(Collectors.toList());

        return users;
    }
}
