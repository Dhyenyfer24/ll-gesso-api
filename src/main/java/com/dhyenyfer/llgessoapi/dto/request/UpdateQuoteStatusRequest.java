package com.dhyenyfer.llgessoapi.dto.request;

import com.dhyenyfer.llgessoapi.entity.QuoteStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateQuoteStatusRequest {

    @NotNull(message = "Status is required")
    private QuoteStatus status;
}