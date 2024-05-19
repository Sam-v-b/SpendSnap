package com.sam.SpendSnap.controller;

import com.sam.SpendSnap.dto.CategoryDto;
import com.sam.SpendSnap.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST APIs For Category Resource",
        description = "CRUD REST APIs For Category Resource - Create Category" +
                "Update Category, Get Category & Delete Category"
)
@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    // http://localhost:8080/swagger-ui/index.html
    private CategoryService categoryService;

    // Create category REST API
    // http://localhost:8080/api/categories
    @Operation(
            summary = "Create Category - REST API",
            description ="REST endpoint to save Category into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    // Get category by ID REST API
    // http://localhost:8080/api/categories/get/1
    @Operation(
            summary = "Get Specific Category - REST API",
            description ="REST endpoint to get the Category from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDto category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    // Get all categories REST API
    // http://localhost:8080/api/categories/getAll
    @Operation(
            summary = "Get All Categories - REST API",
            description ="REST endpoint to get all the Categories from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categoryList = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    // Update category REST API
    // http://localhost:8080/api/categories/update/1
    @Operation(
            summary = "Update Category - REST API",
            description ="REST endpoint to update the Category in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId,categoryDto);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    // Delete category REST API
    // http://localhost:8080/api/categories/delete/1
    @Operation(
            summary = "Delete Category - REST API",
            description ="REST endpoint to delete the Category from a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>("Category deleted Successfully!",HttpStatus.OK);
    }

}
