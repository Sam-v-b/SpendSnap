package com.sam.SpendSnap.dto;

import com.sam.SpendSnap.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
@Schema(
        description ="Expense Dto(Data Transfer Object) to transfer the data between client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense Amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense creation date"
                         )
                         LocalDate expenseDate,
                         @Schema(
                                 description = "Associated Expense Category"
                         )
                         CategoryDto categoryDto ) {
}
