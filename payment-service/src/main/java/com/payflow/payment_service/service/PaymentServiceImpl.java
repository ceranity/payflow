package com.payflow.payment_service.service;

import com.payflow.payment_service.dto.PaymentRequestDTO;
import com.payflow.payment_service.dto.PaymentResponseDTO;
import com.payflow.payment_service.mapper.PaymentEventMapper;
import com.payflow.payment_service.mapper.PaymentMapper;
import com.payflow.payment_service.messaging.PaymentPublisher;
import com.payflow.payment_service.mapper.PaymentMapper;
import com.payflow.payment_service.model.Payment;
import com.payflow.payment_service.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final PaymentEventMapper eventMapper;
    private final PaymentPublisher publisher;

    public PaymentServiceImpl(
            PaymentRepository repository,
            PaymentMapper mapper,
            PaymentEventMapper eventMapper,
            PaymentPublisher publisher
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.eventMapper = eventMapper;
        this.publisher = publisher;
    }

    @Override
    @Transactional
    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {

        Payment payment = mapper.toModel(request);

        Payment saved = repository.save(payment);

        publisher.publishPaymentCreated(
                eventMapper.toEventDTO(saved)
        );

        return mapper.toDTO(saved);
    }

    public List<PaymentResponseDTO> getPayments() {
        List<Payment> payments = repository.findAll();

        List<PaymentResponseDTO> paymentResponseDTO =
                payments.stream().map(patient -> PaymentMapper.toDTO(payments)).toList();

        return paymentResponseDTO;

    }
    public PaymentResponseDTO getPaymentById(UUID id){
        Payment payment = repository.findById(id);
        PaymentResponseDTO paymentResponseDTO = PaymentMapper.toDTO(payment);
        return paymentResponseDTO;
    }
}



