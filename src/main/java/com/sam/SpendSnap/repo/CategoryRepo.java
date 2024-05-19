package com.sam.SpendSnap.repo;

import com.sam.SpendSnap.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
