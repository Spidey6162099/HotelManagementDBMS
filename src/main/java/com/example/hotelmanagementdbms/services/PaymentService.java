package com.example.hotelmanagementdbms.services;

import com.example.hotelmanagementdbms.entities.Payment;
import com.example.hotelmanagementdbms.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments(){
        return paymentRepository.getAllPayments();
    }

}
