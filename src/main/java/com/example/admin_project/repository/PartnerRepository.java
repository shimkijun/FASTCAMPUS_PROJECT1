package com.example.admin_project.repository;

import com.example.admin_project.model.entity.Category;
import com.example.admin_project.model.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    List<Partner> findByCategory(Category category);
}
