package com.sam.SpendSnap.mapper;

import com.sam.SpendSnap.dto.CategoryDto;
import com.sam.SpendSnap.dto.ExpenseDto;
import com.sam.SpendSnap.entity.Category;
import com.sam.SpendSnap.entity.Expense;

public class ExpenseMapper {
    // Mapping Expense entity to ExpenseDto
    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                ));
    }

    // Mapping ExpenseDto to Expense entity
    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        return new Expense(expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category);
    }

}
