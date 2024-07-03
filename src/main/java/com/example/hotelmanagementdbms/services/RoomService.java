package com.example.hotelmanagementdbms.services;

import com.example.hotelmanagementdbms.entities.Room;
import com.example.hotelmanagementdbms.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }
}
