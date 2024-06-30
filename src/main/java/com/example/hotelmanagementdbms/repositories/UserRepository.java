package com.example.hotelmanagementdbms.repositories;

import com.example.hotelmanagementdbms.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("select u from User u where u.username= :username")
    public User findUserByUsername(String username);
}
