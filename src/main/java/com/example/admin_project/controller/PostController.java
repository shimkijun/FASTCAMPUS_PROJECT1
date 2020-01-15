package com.example.admin_project.controller;

import com.example.admin_project.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <form>
    // ajax 검색
    // http post body -> data
    // json, xml, multipart-form / text-plain
    @RequestMapping(method= RequestMethod.POST , path = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){

        return searchParam;
    }

    @PutMapping
    public  void putMethod(){

    }

    @PatchMapping
    public void patchMethod(){

    }

    @DeleteMapping
    public void deleteMethod(){

    }
}
