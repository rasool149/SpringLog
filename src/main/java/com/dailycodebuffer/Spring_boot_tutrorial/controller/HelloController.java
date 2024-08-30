package com.dailycodebuffer.Spring_boot_tutrorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/")
   public String helloWOrld(){
               return welcomeMessage;
}
}
