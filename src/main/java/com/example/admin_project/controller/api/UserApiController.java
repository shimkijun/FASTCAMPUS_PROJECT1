package com.example.admin_project.controller.api;

import com.example.admin_project.ifs.CrudInterface;
import com.example.admin_project.model.network.Header;
import com.example.admin_project.model.network.request.UserApiRequest;
import com.example.admin_project.model.network.response.UserApiResponse;
import com.example.admin_project.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping({"id"})  // /api/user/{id}
    public Header delete(Long id) {
        return null;
    }
}
