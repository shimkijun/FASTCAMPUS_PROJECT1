package com.example.admin_project.repository;

import com.example.admin_project.model.entity.User;
import com.example.admin_project.model.enumclass.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void create(){
        String account = "Test02";
        String password = "Test02";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test02@gmail.com";
        String phoneNumber ="010-2222-2222";
        LocalDateTime registeredAt = LocalDateTime.now();

        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
        if(user != null) {
            user.getOrderGroups().stream().forEach(orderGroup -> {

                System.out.println("------------------------주문묶음----------------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());
                System.out.println("------------------------주문상세----------------------");
                orderGroup.getOrderDetails().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 :"+orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : "+ orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : "+ orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : "+ orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : "+ orderDetail.getStatus());
                    System.out.println("도착예정일자 : "+ orderDetail.getArrivalDate());
                });
            });
        }
        Assertions.assertNotNull(user);
    }

    @Test
    @Transactional
    public void update(){

        // findById 를 기준으로 update 함
        Optional<User> user = userRepository.findById(10L);

        user.ifPresent(selectUser ->{
           selectUser.setAccount("pppp");
           selectUser.setUpdatedAt(LocalDateTime.now());
           selectUser.setUpdatedBy("update method");

           userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional  // 메소드는 모두 실행하지만 실제 데이터베이스의 데이터는 남아있음 = Roll back
    public void delete(){
        Optional<User> user = userRepository.findById(11L);

        Assertions.assertTrue(user.isPresent()); // true

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(11L);

        Assertions.assertFalse(deleteUser.isPresent()); // false
    }

}
