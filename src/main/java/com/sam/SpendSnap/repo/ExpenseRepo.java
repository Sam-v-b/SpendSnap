package com.sam.SpendSnap.repo;

import com.sam.SpendSnap.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense,Long> {
}
