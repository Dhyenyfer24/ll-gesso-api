package com.dhyenyfer.llgessoapi.dto.response;

import com.dhyenyfer.llgessoapi.entity.QuoteStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteResponse {

    private Long id;

    private String clientName;

    private String phone;

    private String city;

    private String neighborhood;

    private String serviceType;

    private Double squareMeters;

    private String serviceDescription;

    private LocalDateTime createdAt;

    private QuoteStatus status;
}