package com.payflow.payment_service.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "payment.exchange";
    public static final String PAYMENT_CREATED_QUEUE = "payment.created.queue";
    public static final String ROUTING_KEY_CREATED = "payment.created";

    @Bean
    public TopicExchange exchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE)
                .durable(true)
                .build();
    }

    @Bean
    public Queue paymentCreatedQueue() {
        return QueueBuilder
                .durable(PAYMENT_CREATED_QUEUE)
                .build();
    }

    @Bean
    public Binding bindingCreated(Queue paymentCreatedQueue,
                                  TopicExchange exchange) {
        return BindingBuilder
                .bind(paymentCreatedQueue)
                .to(exchange)
                .with(ROUTING_KEY_CREATED);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}


