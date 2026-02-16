package com.payflow.notification_service.consumer;


import com.payflow.notification_service.config.RabbitMQConfig;
import com.payflow.notification_service.dto.PaymentEventDTO;
import com.payflow.notification_service.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {

    private final NotificationService notificationService;

    public PaymentEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handlePaymentCreated(PaymentEventDTO event) {
        notificationService.processNotification(event);
    }
}