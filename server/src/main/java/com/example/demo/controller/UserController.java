package com.example.demo.controller;

import com.example.demo.entity.UserQueryParam;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //返回数据的入口controller
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    //注入访问对象
    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/getPage",method = RequestMethod.POST)
    public Map getPage(@RequestBody UserQueryParam userQueryParam){
        //逻辑：查询总条数，查询分页数据
        //查询总条数
        int total = userMapper.getPageCount(userQueryParam);
        //查询分页数据
        List<UserVo> users = userMapper.getPage(userQueryParam);
        Map map = new HashMap();
        map.put("total",total);
        map.put("data",users);
        return map;
    }

//    用来处理地址映射请求的注解，用于类上，大多数是为了进行区分controller，对方法进行注解以产生访问的路径。
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public int count(){
        return userMapper.count();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.GET)
    public User findOne(@PathVariable String code){
        return userMapper.findOne(code);
    }

    //保存用户，0=失败，1=成功
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public int save(@RequestBody User user){
        try {
            userMapper.save(user);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.PUT)
    public int update(@PathVariable String code,@RequestBody User user){
        try {
            user.setCode(code);
            userMapper.update(user);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping(value = "/{code}",method = RequestMethod.DELETE)
    public int delete(@PathVariable String code){
        try {
            userMapper.delete(code);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
