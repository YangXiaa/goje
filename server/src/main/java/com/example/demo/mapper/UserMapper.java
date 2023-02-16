package com.example.demo.mapper;

import java.util.List;
import com.example.demo.entity.User;

public interface UserMapper {
    int count();
    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(User user);

    User findOne(User user);


}
