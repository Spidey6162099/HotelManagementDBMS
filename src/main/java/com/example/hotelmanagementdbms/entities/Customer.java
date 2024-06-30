package com.example.hotelmanagementdbms.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(unique = true)
    private Long customerContact;

    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @Temporal(TemporalType.DATE)
    private Date exitDate;

    private Long customerCost;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(Long customerContact) {
        this.customerContact = customerContact;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public Long getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(Long customerCost) {
        this.customerCost = customerCost;
    }
}
