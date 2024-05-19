package com.sam.SpendSnap.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(
        description = "Error Details DTO(Data Transfer Object) to transfer error response data between client ans server"
)
@Data
public class ErrorDetails {
    @Schema(
            description = "Error occurrence Date and time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "Error Message"
    )
    private String message;
    @Schema(
            description = "Error Details"
    )
    private String details;
    @Schema(
            description = "Error Code"
    )
    private String errorCode;
}
