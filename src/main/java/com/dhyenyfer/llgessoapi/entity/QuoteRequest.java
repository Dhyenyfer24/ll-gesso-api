package com.dhyenyfer.llgessoapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "quote_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    private String phone;

    private String city;

    private String neighborhood;

    private String serviceType;

    private Double squareMeters;

    private String serviceDescription;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private QuoteStatus status;
}