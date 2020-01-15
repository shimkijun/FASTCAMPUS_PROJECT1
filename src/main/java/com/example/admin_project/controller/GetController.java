package com.example.admin_project.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public  String getRequest(){
        return "Hi getMethod";
    }

    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id , @RequestParam(name="password") String pwd){
        String password = "1234";
        System.out.println("id :" + id);
        System.out.println("password :" + pwd);

        return id+password;
    }

}
