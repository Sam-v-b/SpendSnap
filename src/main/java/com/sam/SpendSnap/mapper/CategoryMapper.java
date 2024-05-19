package com.sam.SpendSnap.mapper;

import com.sam.SpendSnap.dto.CategoryDto;
import com.sam.SpendSnap.entity.Category;

public class CategoryMapper {
    // Mapping CategoryDto to Category entity
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.id(),
                categoryDto.name());
    }

    // Mapping Category entity to CategoryDto
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName());
    }
}
