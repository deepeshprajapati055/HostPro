package com.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.room.entity.Room;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer>{
	
}
