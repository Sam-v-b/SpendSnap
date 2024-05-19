package com.sam.SpendSnap.service;

import com.sam.SpendSnap.dto.ExpenseDto;
import com.sam.SpendSnap.entity.Category;
import com.sam.SpendSnap.entity.Expense;
import com.sam.SpendSnap.exception.ResourceNotFoundException;
import com.sam.SpendSnap.mapper.ExpenseMapper;
import com.sam.SpendSnap.repo.CategoryRepo;
import com.sam.SpendSnap.repo.ExpenseRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepo expenseRepo;
    private CategoryRepo categoryRepo;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepo.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepo.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("No Expenses are found with this ID : " + expenseId));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepo.findAll();
        return expenses.stream()
                .map(expense -> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepo.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("No Expenses are found with this ID : " + expenseId));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        if (expenseDto.categoryDto() != null) {
            Category category = categoryRepo.findById(expenseDto.categoryDto().id())
                    .orElseThrow(() -> new ResourceNotFoundException("No categories are found with this ID : " + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }
        Expense updatedExpense = expenseRepo.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepo.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("No Expenses are found with this ID : " + expenseId));
        expenseRepo.delete(expense);
    }
}
