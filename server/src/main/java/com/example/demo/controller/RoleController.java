package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public int count(){
        return roleMapper.count();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Role> findAll(){
        return roleMapper.findAll();
    }

    @RequestMapping(value = "/{role_name}",method = RequestMethod.POST)
    public Role findOne(@PathVariable String roleName){
        return roleMapper.findOne(roleName);
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public int save(@RequestBody Role role){
        try {
            roleMapper.insert(role);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/{role_name}",method = RequestMethod.PUT)
    public int update(@PathVariable String roleName, @RequestBody Role role){
        try {
            roleMapper.update(role);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/{role_name}",method = RequestMethod.DELETE)
    public int delete(@PathVariable String roleName){
        try {
            roleMapper.delete(roleName);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
