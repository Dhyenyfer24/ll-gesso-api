package com.dhyenyfer.llgessoapi.service;

import com.dhyenyfer.llgessoapi.dto.request.CreateQuoteRequest;
import com.dhyenyfer.llgessoapi.dto.request.UpdateQuoteStatusRequest;
import com.dhyenyfer.llgessoapi.dto.response.QuoteResponse;
import com.dhyenyfer.llgessoapi.entity.QuoteRequest;
import com.dhyenyfer.llgessoapi.entity.QuoteStatus;
import com.dhyenyfer.llgessoapi.exception.ResourceNotFoundException;
import com.dhyenyfer.llgessoapi.repository.QuoteRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuoteService {

    private final QuoteRequestRepository quoteRequestRepository;

    public QuoteService(QuoteRequestRepository quoteRequestRepository) {
        this.quoteRequestRepository = quoteRequestRepository;
    }

    public QuoteResponse create (CreateQuoteRequest request) {

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

        QuoteRequest savedQuote =
                quoteRequestRepository.save(quoteRequest);

        return toResponse(savedQuote);
    }


    public List<QuoteResponse> getAll() {

        List<QuoteRequest> quotes =
                quoteRequestRepository.findAll();

        List<QuoteResponse> response = new ArrayList<>();

        for (QuoteRequest quote : quotes) {

            response.add (toResponse(quote)
            );
        }
        return response;
    }

    public QuoteResponse updateStatus(
            Long id,
            UpdateQuoteStatusRequest request
    ) {

        QuoteRequest quote = quoteRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found"));

        quote.setStatus(request.getStatus());

       QuoteRequest updateQuote =
               quoteRequestRepository.save(quote);
       return toResponse(updateQuote);
    }

    public QuoteResponse getById (Long id) {
        QuoteRequest quote = quoteRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quote not found"));

        return toResponse(quote);

    }
    private QuoteResponse toResponse (QuoteRequest quote) {
        return QuoteResponse.builder()
                .id(quote.getId())
                .clientName(quote.getClientName())
                .phone(quote.getPhone())
                .city(quote.getCity())
                .neighborhood(quote.getNeighborhood())
                .serviceType(quote.getServiceType())
                .squareMeters(quote.getSquareMeters())
                .serviceDescription(quote.getServiceDescription())
                .createdAt(quote.getCreatedAt())
                .status(quote.getStatus())
                .build();
    }


}




