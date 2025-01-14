package com.room.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.entity.Room;
import com.room.repository.RoomRepo;
import com.room.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomRepo roomRepo;
	
	@Override
	public Room saveRoom(Room room) {
		return this.roomRepo.save(room);
	}

	@Override
	public List<Room> showAllRooms() {
		return this.roomRepo.findAll();
	}

	@Override
	public void removeRoom(Integer id) {
		roomRepo.deleteById(id);
	}

	@Override
	public Room getUserById(Integer id) {
		Optional<Room> u = this.roomRepo.findById(id);
		if(u.isEmpty()) {
			return null;
		}else {
			return u.get();
		}
	}

	@Override
	public Room updateRoom(Room room) {
		Optional<Room> roo = this.roomRepo.findById(room.getId());
		if(roo.isEmpty()) {
			return null;
		}else {
			return roomRepo.save(room);
		}
	}

	@Override
	public Long getTotalRooms() {
		return this.roomRepo.count();
	}

	@Override
	public Long getOccupiedRooms() {
		return this.roomRepo.findAll().stream().filter(room -> room.getStatus().equalsIgnoreCase("Occupied")).count();
	}

	@Override
	public Long getNotOccupiedRooms(){
		return this.roomRepo.findAll().stream().filter(room -> room.getStatus().equalsIgnoreCase("Not Occupied")).count();
	}

	@Override
	public Long getUnderMaintanance() {
		return this.roomRepo.findAll().stream().filter(room -> room.getStatus().equalsIgnoreCase("Under Maintenance")).count();
	}

}
