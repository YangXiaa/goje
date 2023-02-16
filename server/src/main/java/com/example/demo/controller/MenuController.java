package com.example.demo.controller;

import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping(value = "/menuCount",method = RequestMethod.GET)
    public int menuCount(){
        return menuMapper.menuCount();
    }
}
