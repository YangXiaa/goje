package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping(value = "/roleCount",method = RequestMethod.GET)
    public int count(){
        return roleMapper.count();
    }

    @RequestMapping(value = "/roleFindAll",method = RequestMethod.GET)
    public List<Role> findAll(){
        return roleMapper.findAll();
    }

    @RequestMapping(value = "/roleFindOne",method = RequestMethod.POST)
    public Role findOne(@RequestBody Role role){
        return roleMapper.findOne(role);
    }

    @RequestMapping(value = "roleSave",method = RequestMethod.POST)
    public int save(@RequestBody Role role){
        try {
            roleMapper.insert(role);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "roleUpdate",method = RequestMethod.POST)
    public int update(@RequestBody Role role){
        try {
            roleMapper.update(role);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "roleDelete",method = RequestMethod.POST)
    public int delete(@RequestBody Role role){
        try {
            roleMapper.delete(role);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
