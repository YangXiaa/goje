package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //返回数据的入口controller
public class UserController {

    //注入访问对象
    @Autowired
    private UserMapper userMapper;

//    用来处理地址映射请求的注解，用于类上，大多数是为了进行区分controller，对方法进行注解以产生访问的路径。
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public int count(){
        return userMapper.count();
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public User findOne(@RequestBody User user){
        return userMapper.findOne(user);
    }

    //保存用户，0=失败，1=成功
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public int save(@RequestBody User user){
        try {
            userMapper.save(user);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public int update(@RequestBody User user){
        try {
            userMapper.update(user);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public int delete(@RequestBody User user){
        try {
            userMapper.delete(user);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
