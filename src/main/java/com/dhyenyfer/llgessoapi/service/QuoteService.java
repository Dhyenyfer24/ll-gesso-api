package com.dhyenyfer.llgessoapi.service;

import com.dhyenyfer.llgessoapi.dto.request.CreateQuoteRequest;
import com.dhyenyfer.llgessoapi.entity.QuoteRequest;
import com.dhyenyfer.llgessoapi.entity.QuoteStatus;
import com.dhyenyfer.llgessoapi.repository.QuoteRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuoteService {

    private final QuoteRequestRepository quoteRequestRepository;

    public QuoteService(QuoteRequestRepository quoteRequestRepository) {
        this.quoteRequestRepository = quoteRequestRepository;
    }

    public QuoteRequest create(CreateQuoteRequest request) {

        QuoteRequest quoteRequest = QuoteRequest.builder()
                .clientName(request.getClientName())
                .phone(request.getPhone())
                .city(request.getCity())
                .neighborhood(request.getNeighborhood())
                .serviceType(request.getServiceType())
                .squareMeters(request.getSquareMeters())
                .serviceDescription(request.getServiceDescription())
                .createdAt(LocalDateTime.now())
                .status(QuoteStatus.PENDING)
                .build();

        return quoteRequestRepository.save(quoteRequest);
    }
}