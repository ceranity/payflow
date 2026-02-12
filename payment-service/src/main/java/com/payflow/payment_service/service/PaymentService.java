package com.payflow.payment_service.service;

import com.payflow.payment_service.dto.PaymentRequestDTO;
import com.payflow.payment_service.dto.PaymentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO);
    List<PaymentResponseDTO> getPayments();

    PaymentResponseDTO getPaymentById(UUID id);
}
