package com.example.hotelmanagementdbms.services;

import com.example.hotelmanagementdbms.entities.Customer;
import com.example.hotelmanagementdbms.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
