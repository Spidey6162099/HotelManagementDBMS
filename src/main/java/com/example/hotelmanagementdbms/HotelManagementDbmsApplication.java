package com.example.hotelmanagementdbms;

import com.example.hotelmanagementdbms.entities.User;
import com.example.hotelmanagementdbms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class HotelManagementDbmsApplication {

    @Autowired
    UserService userService;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http    .authorizeHttpRequests(auth->auth.anyRequest().permitAll())
                .csrf(csrf->csrf.disable())
                .httpBasic(basic->basic.disable())
                .cors(cor->cor.configurationSource(request -> {
                    var cors = new CorsConfiguration();
                    cors.setAllowedOrigins(List.of("http://localhost:4173", "http://127.0.0.1:80", "http://example.com"));
                    cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
                    cors.setAllowedHeaders(List.of("*"));
                    return cors;
                }));
        return http.build();
    }



    public static void main(String[] args) {

        SpringApplication.run(HotelManagementDbmsApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            User admin=new User();
//            admin.setPassword("password");
//            admin.setUsername("username");
//
//            userService.save(admin);
//        };
//    }

}
