package com.example.hotelmanagementdbms.repositories;

import com.example.hotelmanagementdbms.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
    @Query(value = "select * from Room ",nativeQuery = true)
    public List<Room> getAllRooms();
}
