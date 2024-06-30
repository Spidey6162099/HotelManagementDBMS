package com.example.hotelmanagementdbms.services;

import com.example.hotelmanagementdbms.entities.User;
import com.example.hotelmanagementdbms.repositories.UserRepository;
import jakarta.persistence.Entity;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;

@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;



        public boolean check(User user) {
                BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

                try {
                        User userInDatabase = userRepository.findUserByUsername(user.getUsername());

                        String hashedPassword = bCryptPasswordEncoder.encode(user.getPassword());

                        if(bCryptPasswordEncoder.matches(user.getPassword(),userInDatabase.getPassword())){
                                return true;
                        }
                        else {
                                return false;
                        }
                }
                catch(Exception e){
                      return false;
                }


        }

        public void save(User user){
                BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

                String encryptedPassword=bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encryptedPassword);
                userRepository.save(user);
        }
}
