package com.example.hotelmanagementdbms.services;

import com.example.hotelmanagementdbms.entities.AddCustomerDTO;
import com.example.hotelmanagementdbms.entities.Customer;
import com.example.hotelmanagementdbms.entities.Payment;
import com.example.hotelmanagementdbms.entities.Room;
import com.example.hotelmanagementdbms.repositories.CustomerRepository;
import com.example.hotelmanagementdbms.repositories.PaymentRepository;
import com.example.hotelmanagementdbms.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public boolean save(AddCustomerDTO addCustomerDTO){





        try{
            //customer
            Customer customer=new Customer();
            customer.setCustomerName(addCustomerDTO.getCustomer_name());
            customer.setCustomerCost(addCustomerDTO.getPayment());
            customer.setRoomNum(addCustomerDTO.getRoomNum());
            customer.setEntryDate(addCustomerDTO.getCheckinDate());
            customer.setCustomerContact(addCustomerDTO.getCustomerContact());

            customerRepository.save(customer);
            Customer newCustomer=customerRepository.getCustomersByCustomerContact(addCustomerDTO.getCustomerContact());

            //payment
            Payment payment=new Payment();
            payment.setPaymentAmount(addCustomerDTO.getPayment());
            payment.setPaymentDate(addCustomerDTO.getCheckoutDate());
            payment.setCustomerId(newCustomer.getCustomerId());

            paymentRepository.save(payment);

            //room

            Room room=new Room();
            room.setRoomCost(addCustomerDTO.getPayment());
            room.setRoomType(addCustomerDTO.getRoomType());
            room.setRoomNum(addCustomerDTO.getRoomNum());
            roomRepository.save(room);

            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
