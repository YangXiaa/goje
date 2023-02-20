package com.example.demo.mapper;

import com.example.demo.entity.Menu;

import java.util.List;

public interface MenuMapper {
    int count();

    List<Menu> findAll();

    Menu findOne(Menu menu);

    void save(Menu menu);

    void update(Menu menu);

    void delete(Menu menu);
}
