package com.example.hotelmanagementdbms.repositories;

import com.example.hotelmanagementdbms.entities.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Long> {
    @Query(value = "select * from Payment ",nativeQuery = true)
    public List<Payment> getAllPayments();

    public Payment getPaymentByCustomerId(Long customerId);
}
