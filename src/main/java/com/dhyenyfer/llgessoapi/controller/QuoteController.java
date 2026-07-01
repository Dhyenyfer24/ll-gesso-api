package com.dhyenyfer.llgessoapi.controller;

import com.dhyenyfer.llgessoapi.dto.request.CreateQuoteRequest;
import com.dhyenyfer.llgessoapi.entity.QuoteRequest;
import com.dhyenyfer.llgessoapi.service.QuoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<QuoteRequest> create(
            @Valid @RequestBody CreateQuoteRequest dto
    ) {

        QuoteRequest quote = quoteService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quote);
    }
}