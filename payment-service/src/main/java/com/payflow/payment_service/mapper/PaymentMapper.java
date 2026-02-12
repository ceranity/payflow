package com.payflow.payment_service.mapper;

import com.payflow.payment_service.dto.PaymentEventDTO;
import com.payflow.payment_service.dto.PaymentRequestDTO;
import com.payflow.payment_service.dto.PaymentResponseDTO;
import com.payflow.payment_service.model.Payment;

public class PaymentMapper {
    public static PaymentResponseDTO toDTO(Payment payment){
        PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO();
        paymentResponseDTO.setId(payment.getId());
        paymentResponseDTO.setAmount(payment.getAmount());
        paymentResponseDTO.setCurrency(payment.getCurrency());
        paymentResponseDTO.setStatus(payment.getStatus().name());
        paymentResponseDTO.setCreatedAt(payment.getCreatedAt());

        return paymentResponseDTO;

    }

    public static Payment toModel(PaymentRequestDTO paymentRequestDTO){
        if (paymentRequestDTO == null) {
            return null;
        }
        Payment payment = new Payment();
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setCurrency(paymentRequestDTO.getCurrency());

        return payment;
    }

}
