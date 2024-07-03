package com.example.hotelmanagementdbms.repositories;

import com.example.hotelmanagementdbms.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query(value = "select * from Customer ",nativeQuery = true)
    public List<Customer> getAllCustomers();

    public Customer getCustomersByCustomerContact(Long customerContact);
}
