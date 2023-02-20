package com.example.demo.controller;

import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Menu;

import java.util.List;


@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

//    查询记录数
    @RequestMapping(value = "/menuCount",method = RequestMethod.GET)
    public int count(){
        return menuMapper.count();
    }
//    查询所有记录

    @RequestMapping(value = "/menuFindAll",method = RequestMethod.GET)
    public List<Menu> findAll(){
        return menuMapper.findAll();
    }

    @RequestMapping(value = "/menuFindOne",method = RequestMethod.POST)
    public Menu findOne(@RequestBody Menu menu){
        return menuMapper.findOne(menu);
    }

    /*增加记录*/
    @RequestMapping(value = "/menuSave",method = RequestMethod.POST)
    public int menuSave(@RequestBody Menu menu){
        try {
            menuMapper.save(menu);
            return 1;
        }catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

//    修改
    @RequestMapping(value = "/menuUpdate",method = RequestMethod.POST)
    public int update(@RequestBody Menu menu){
      try {
         menuMapper.update(menu);
         return 1;
      }catch (Exception e) {
         System.out.println(e);
         return 0;
      }
    }

//    删除记录
    @RequestMapping(value = "/menuDelete",method = RequestMethod.POST)
    public int delete(@RequestBody Menu menu){
        try {
            menuMapper.delete(menu);
            return 1;
        }catch (Exception e) {
          System.out.println(e);
           return 0;
      }
    }
}
