package com.example.admin_project.repository;

import com.example.admin_project.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);
        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(),type);
        Assertions.assertEquals(newCategory.getTitle(),title);
    }

    @Test
    void read(){
        Long id = 1L;
        String type = "COMPUTER";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        // select * from category whre type = 'COMPUTER'

        optionalCategory.ifPresent(c ->{
            Assertions.assertEquals(c.getType(),type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }

}
