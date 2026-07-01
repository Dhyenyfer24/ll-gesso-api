package com.dhyenyfer.llgessoapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateQuoteRequest {

    @NotBlank(message = "Client name is required")
    private String clientName;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "City is required")
    private String city;

    private String neighborhood;

    @NotBlank(message = "Service is required")
    private String serviceType;

    @NotNull(message = "Square meters is required")
    private Double squareMeters;

    private String serviceDescription;

}
