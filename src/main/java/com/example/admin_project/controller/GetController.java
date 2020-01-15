package com.example.admin_project.controller;

import com.example.admin_project.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetController {

    // localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public  String getRequest(){
        return "Hi getMethod";
    }

    // localhost:8080/api/getParameter?id=abcd&password=1234
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id , @RequestParam String password){
        System.out.println("id :" + id);
        System.out.println("password :" + password);

        return id+password;
    }

    // 로컬 변수와 파마리터 값이 같을경우 name값을 지정하여 변수명을 변경 가능
    // localhost:8080/api/getParameter1?id=abcd&password=1234
    @GetMapping("/getParameter2")
    public String getParameter2(@RequestParam String id , @RequestParam(name="password") String pwd){
        String password = "1234";
        System.out.println("id :" + id);
        System.out.println("password :" + pwd);

        return id+password;
    }

    // 스프링 부트 에서는 객체를 리턴 하면 기본값이 JSON 방식
    // localhost:8080/api/getMultiParameter?account=abcd&email=a@gmail.com&page=10
    @GetMapping("getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "" , "email" : "" , "page" : 0 }
        return searchParam;
    }

}
