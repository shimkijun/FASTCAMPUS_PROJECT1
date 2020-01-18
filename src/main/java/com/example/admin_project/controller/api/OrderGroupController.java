package com.example.admin_project.controller.api;

import com.example.admin_project.controller.CrudController;
import com.example.admin_project.model.entity.OrderGroup;
import com.example.admin_project.model.network.request.OrderGroupApiRequest;
import com.example.admin_project.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupController extends CrudController<OrderGroupApiRequest,OrderGroupApiResponse, OrderGroup> {

}
