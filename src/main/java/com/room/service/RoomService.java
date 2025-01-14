package com.room.service;

import java.util.List;

import com.room.entity.Room;

public interface RoomService {
	
	Room saveRoom(Room room);		//CREATE
	
	List<Room> showAllRooms();		//VIEW
	
	void removeRoom(Integer id);	//Delete
	
	Room getUserById(Integer id);	
	
	Room updateRoom(Room room);
	
	Long getTotalRooms();
	
	Long getOccupiedRooms();
	
	Long getNotOccupiedRooms();
	
	Long getUnderMaintanance();
}
