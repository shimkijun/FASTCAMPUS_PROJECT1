package com.example.admin_project.controller.api;

import com.example.admin_project.controller.CrudController;
import com.example.admin_project.model.entity.Item;
import com.example.admin_project.model.network.request.ItemApiRequest;
import com.example.admin_project.model.network.response.ItemApiResponse;
import com.example.admin_project.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest,ItemApiResponse, Item> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }

}
