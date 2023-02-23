package com.example.demo.mapper;

import java.util.List;
import com.example.demo.entity.User;
import com.example.demo.entity.UserVo;
import com.example.demo.entity.UserQueryParam;

public interface UserMapper {
    int count();
    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(String code);

    User findOne(String code);


    int getPageCount(UserQueryParam userQueryParam);

    List<UserVo> getPage(UserQueryParam userQueryParam);
}
