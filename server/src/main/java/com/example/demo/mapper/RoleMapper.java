package com.example.demo.mapper;

import com.example.demo.entity.Role;


import java.util.List;

public interface RoleMapper {

    int count();

    List<Role> findAll();

    Role findOne(String roleName);

    void insert(Role role);

    void update(Role role);

    void delete(String roleName);
}
