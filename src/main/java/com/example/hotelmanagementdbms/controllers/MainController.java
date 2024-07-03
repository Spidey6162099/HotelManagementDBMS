package com.example.hotelmanagementdbms.controllers;

import com.example.hotelmanagementdbms.entities.*;
import com.example.hotelmanagementdbms.services.*;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin
@Controller
public class MainController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PaymentService paymentService;



    @Autowired
    private FormService formService;





//    @ResponseBody
//    @GetMapping("/Galvanic/all")
//    public List<Customer> showAllCustomers(){
//        return customerService.getAllCustomers();
//    }


    @ResponseBody
    @PostMapping("/Galvanic/login")
    public ResponseEntity<String> verifyLogin(@RequestBody UserDTO userDTO){



        User user=new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());


            if(userService.check(user)){
                return new ResponseEntity<>(HttpStatus.OK);
            }

            else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

        }

        @ResponseBody
        @PostMapping("/Galvanic/customers/add")

        public ResponseEntity<String> addNewCustomer(@RequestBody AddCustomerDTO addCustomerDTO){

            if(formService.save(addCustomerDTO)){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }


        }

        @ResponseBody
        @PostMapping("/Galvanic/customers/delete/{customerid}")

        public ResponseEntity<String> deleteCustomer(@PathVariable  Long customerid){

            try {
                formService.delete(customerid);


                return new ResponseEntity<>(HttpStatus.OK);
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        @ResponseBody
        @PostMapping("/Galvanic/customers/update")

        public ResponseEntity<String> updateCustomer(@RequestBody AddCustomerDTO addCustomerDTO){
        return new ResponseEntity<>(HttpStatus.OK);
        }

        @ResponseBody
        @GetMapping("/Galvanic/customers")
        public List<Customer> getAllCustomers(){
            return customerService.getAllCustomers();
        }

    @ResponseBody
    @GetMapping("/Galvanic/rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @ResponseBody
    @GetMapping("/Galvanic/payments")
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

}
