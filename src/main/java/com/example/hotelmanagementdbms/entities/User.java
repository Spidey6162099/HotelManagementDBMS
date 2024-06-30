package com.example.hotelmanagementdbms.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;



    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;
    @Column(unique = true)
    private String email;

//    @NonNull
//    private String roles;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @NonNull
//    public String getRoles() {
//        return roles;
//    }
//
//    public void setRoles(@NonNull String roles) {
//        this.roles = roles;
//    }
}
