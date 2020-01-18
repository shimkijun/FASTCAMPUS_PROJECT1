package com.example.admin_project.controller.api;

import com.example.admin_project.controller.CrudController;
import com.example.admin_project.model.entity.Partner;
import com.example.admin_project.model.network.request.PartnerApiRequest;
import com.example.admin_project.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
