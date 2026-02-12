package com.payflow.payment_service.mapper;

import com.payflow.payment_service.dto.PaymentEventDTO;
import com.payflow.payment_service.model.Payment;

public class PaymentEventMapper {
    public static PaymentEventDTO toEventDTO(Payment payment) {

        if (payment == null) {
            return null;
        }

        PaymentEventDTO paymentEventDTO = new PaymentEventDTO();
        paymentEventDTO.setPaymentId(payment.getId());
        paymentEventDTO.setAmount(payment.getAmount());
        paymentEventDTO.setCurrency(payment.getCurrency());
        paymentEventDTO.setStatus(payment.getStatus().name());

        return paymentEventDTO;
    }
}
