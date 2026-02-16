package com.payflow.notification_service.service;


import com.payflow.notification_service.dto.PaymentEventDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class NotificationService {

    public void processNotification(PaymentEventDTO event) {

        System.out.println("📨 Sending notification for payment: "
                + event.getPaymentId());


        if (event.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            throw new RuntimeException("Simulated failure");
        }

        System.out.println("✅ Notification sent successfully.");
    }
}
