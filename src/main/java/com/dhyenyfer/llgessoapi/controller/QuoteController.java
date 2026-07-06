package com.dhyenyfer.llgessoapi.controller;

import com.dhyenyfer.llgessoapi.dto.request.CreateQuoteRequest;
import com.dhyenyfer.llgessoapi.dto.request.UpdateQuoteStatusRequest;
import com.dhyenyfer.llgessoapi.dto.response.QuoteResponse;
import com.dhyenyfer.llgessoapi.entity.QuoteStatus;
import com.dhyenyfer.llgessoapi.service.QuoteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quotes")
@SecurityRequirement (name = "bearerAuth")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping
    public ResponseEntity<QuoteResponse> create(
            @Valid @RequestBody CreateQuoteRequest dto
    ) {

        QuoteResponse response = quoteService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<QuoteResponse> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateQuoteStatusRequest request
    ) {

        QuoteResponse response =
                quoteService.updateStatus(id, request);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<QuoteResponse>> getAll() {
        List<QuoteResponse> response = quoteService.getAll();

        return ResponseEntity.ok(response);

    }

    @GetMapping ("/{id}")
    public ResponseEntity<QuoteResponse> getById (
            @PathVariable Long id
    ) {
        QuoteResponse response =
                quoteService.getById(id);

        return ResponseEntity.ok(response);
    }


}