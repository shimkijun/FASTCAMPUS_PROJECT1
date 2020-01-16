package com.example.admin_project.repository;

import com.example.admin_project.model.entity.User;
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
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERD";
        String email = "Test01@gmail.com";
        String phoneNumber ="010-1111-1111";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-1111");
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
