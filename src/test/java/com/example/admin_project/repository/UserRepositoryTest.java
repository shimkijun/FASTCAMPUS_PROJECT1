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
        User user = new User();
        user.setAccount("TestUser02");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    void read(){
        Optional<User> user = userRepository.findById(10L);

        user.ifPresent(selectUser ->{
            System.out.println("user : " + selectUser );
        });
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
