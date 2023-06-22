package com.example.springbootecs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecs")
public class EcsController {

    @GetMapping("/first")
    public String getMessage(){
        return "Hello This is spring boot ecs application";
    }

    @GetMapping("/second/{name}")
    public String getCustomMessage(@PathVariable(name = "name") String name){
        return "Hello "+name+" this is spring boot application with docker and ECS !";
    }
}
