package com.example.hotelmanagementdbms.controllers;

import com.example.hotelmanagementdbms.entities.Customer;
import com.example.hotelmanagementdbms.entities.User;
import com.example.hotelmanagementdbms.entities.UserDTO;
import com.example.hotelmanagementdbms.services.CustomerService;
import com.example.hotelmanagementdbms.services.UserService;
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




    @ResponseBody
    @GetMapping("/Galvanic/all")
    public List<Customer> showAllCustoemrs(){
        return customerService.getAllCustomers();
    }


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






}
