package com.payflow.payment_service.controller;



import com.payflow.payment_service.dto.PaymentRequestDTO;
import com.payflow.payment_service.dto.PaymentResponseDTO;
import com.payflow.payment_service.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payments", description = "API for managing Payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(
            @Valid @RequestBody PaymentRequestDTO request) {

        PaymentResponseDTO response =
                paymentService.createPayment(request);

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get payment by id")
    public ResponseEntity<PaymentResponseDTO> getPayment(
            @PathVariable UUID id) {

        return ResponseEntity.ok(paymentService.getPaymentById(id));


    }
    @GetMapping
    @Operation(summary = "get all payments")
    public ResponseEntity<List<PaymentResponseDTO>> getPayments(){
        List<PaymentResponseDTO> payments = paymentService.getPayments();
        return ResponseEntity.ok().body(payments);
    }

}


