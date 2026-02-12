package com.payflow.payment_service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentEventDTO {

    private UUID paymentId;
    private BigDecimal amount;
    private String currency;
    private String status;

    public PaymentEventDTO() {}

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
