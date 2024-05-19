package com.sam.SpendSnap.controller;

import com.sam.SpendSnap.dto.CategoryDto;
import com.sam.SpendSnap.dto.ExpenseDto;
import com.sam.SpendSnap.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST APIs For Expense Resource",
        description = "CRUD REST APIs For Expense Resource - Create Expense" +
                "Update Expense, Get Expense & Delete Expense"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    // http://localhost:8080/swagger-ui/index.html
    private ExpenseService expenseService;

    // Create expenseREST API
    // http://localhost:8080/api/expense
    @Operation(
            summary = "Create Expense - REST API",
            description ="REST endpoint to save Expense into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto expense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }
    // Get expense by ID REST API
    // http://localhost:8080/api/expense/get/1
    @Operation(
            summary = "Get Specific Expense - REST API",
            description ="REST endpoint to get the Expense from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId){
        ExpenseDto expense = expenseService.getExpenseById(expenseId);
        return new ResponseEntity<>(expense,HttpStatus.OK);
    }
    // Get all expenses REST API
    // http://localhost:8080/api/expense/getAll
    @Operation(
            summary = "Get All Expenses - REST API",
            description ="REST endpoint to get all the Expenses from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/getAll")
    public  ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses,HttpStatus.OK);
    }

    // Update expense REST API
    // http://localhost:8080/api/expense/update/1
    @Operation(
            summary = "Update Expense - REST API",
            description ="REST endpoint to update the Expense in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                    @RequestBody ExpenseDto expenseDto){
        ExpenseDto expense = expenseService.updateExpense(expenseId,expenseDto);
        return ResponseEntity.ok(expense);
    }

    // Delete expense REST API
    // http://localhost:8080/api/expense/delete/1
    @Operation(
            summary = "Delete Expense - REST API",
            description ="REST endpoint to delete the Expense from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully!");
    }
}
