package com.example.admin_project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // == table
//@Table(name ="user") == 클래스 명과 테이블 명이 같으면 작성 x
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name="account") == 컬럼명과 같으면 작성 x
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1 : N
    // LAZY = 지연로딩 , EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // EAGER = item_id = order_detail.item_id , user_id = order_detail.user_id where item.id = ?
    // EAGER = 1:1 일때 추천
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user")
    private List<OrderDetail> orderDetails;

}
