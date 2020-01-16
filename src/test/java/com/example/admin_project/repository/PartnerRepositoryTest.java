package com.example.admin_project.repository;

import com.example.admin_project.model.entity.Partner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class PartnerRepositoryTest {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-1111";
        String partnerNumber = "010-1111-1111";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;
        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);
        Assertions.assertNotNull(newPartner);

    }

    @Test
    void read(){

    }
}
