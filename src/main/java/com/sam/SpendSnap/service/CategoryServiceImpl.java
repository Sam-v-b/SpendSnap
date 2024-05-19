package com.sam.SpendSnap.service;

import com.sam.SpendSnap.dto.CategoryDto;
import com.sam.SpendSnap.entity.Category;
import com.sam.SpendSnap.exception.ResourceNotFoundException;
import com.sam.SpendSnap.mapper.CategoryMapper;
import com.sam.SpendSnap.repo.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        // Convert CategoryDto to Category entity
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepo.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("No categories are found with this ID : " + categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(category -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("No categories are found with this ID : " + categoryId));
        category.setName(categoryDto.name());
        Category updatedCategory = categoryRepo.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("No categories are found with this ID : " + categoryId));

        categoryRepo.delete(category);
    }
}
