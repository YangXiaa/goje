package com.example.demo.controller;

import com.example.demo.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Menu;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

//    查询记录数
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    public int count(){
        return menuMapper.count();
    }
//    查询所有记录

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Menu> findAll(){
        return menuMapper.findAll();
    }

    @RequestMapping(value = "/{menu_name}",method = RequestMethod.POST)
    public Menu findOne(@PathVariable String menuName){
        return menuMapper.findOne(menuName);
    }

    /*增加记录*/
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public int save(@RequestBody Menu menu){
        try {
            menuMapper.save(menu);
            return 1;
        }catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

//    修改
    @RequestMapping(value = "/{menu_name}",method = RequestMethod.PUT)
    public int update(@PathVariable String menuName, @RequestBody Menu menu){
      try {
         menuMapper.update(menu);
         return 1;
      }catch (Exception e) {
         System.out.println(e);
         return 0;
      }
    }

//    删除记录
    @RequestMapping(value = "/{menu_name}",method = RequestMethod.DELETE)
    public int delete(@PathVariable String menuName){
        try {
            menuMapper.delete(menuName);
            return 1;
        }catch (Exception e) {
          System.out.println(e);
           return 0;
      }
    }
}
