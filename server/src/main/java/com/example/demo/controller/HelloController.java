package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*返回数据*/
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "success";
    }

}
