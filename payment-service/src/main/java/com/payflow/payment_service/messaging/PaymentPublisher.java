
package com.payflow.payment_service.messaging;

import com.payflow.payment_service.config.RabbitMQConfig;
import com.payflow.payment_service.dto.PaymentEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentPublisher {

    private final RabbitTemplate rabbitTemplate;

    public PaymentPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishPaymentCreated(PaymentEventDTO event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY_CREATED,
                event
        );
    }
}

