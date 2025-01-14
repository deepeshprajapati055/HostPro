package com.room.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.room.entity.Room;
import com.room.service.RoomService;

@Controller
public class HomeController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("rooms", roomService.showAllRooms());
		model.addAttribute("totalRooms", roomService.getTotalRooms());
	    model.addAttribute("occupiedRooms", roomService.getOccupiedRooms());
	    model.addAttribute("notOccupiedRooms", roomService.getNotOccupiedRooms());
	    model.addAttribute("underMaintenanceRooms", roomService.getUnderMaintanance());
		return "index";
	}
	
	@GetMapping("/addrooms")
	public String addRoom() {
		return "show";
	}
	
	@PostMapping("/add")
	public String showRooms(@RequestParam("roomno") String roomno,
			@RequestParam("isEmpty") boolean isEmpty, @RequestParam("roomsize") String roomsize,
			@RequestParam("pricepernight") String pricepernight, @RequestParam("roomType") String roomType,
			@RequestParam("floor") Integer floor, @RequestParam("status") String status,
			RedirectAttributes redirectAttributes, Model model) {
		
		Room room = new Room(roomno, isEmpty, roomsize, Double.parseDouble(pricepernight), roomType, floor, status);
		roomService.saveRoom(room);
		model.addAttribute("message", "Room "+room.getRoomno()+" added successfully.");
		return "index";
	}
	
	@GetMapping("/remove/{id}")
	public String deleteRooms(@PathVariable("id") Integer id, Model model) {
		Optional<Room> rm = Optional.ofNullable(roomService.getUserById(id));
		if(rm.isEmpty()) {
			model.addAttribute("error", "Oop's :(  Room not found with id "+id);
			return "index";
		}else {
			roomService.removeRoom(id);
			model.addAttribute("message", "Room "+rm.get().getRoomno()+" is successfully deleted.");
			return "index";
		}
	}
	
	@GetMapping("/updateRoom/{id}")
	public String updateRooms(@PathVariable("id") Integer id, Model model) {
		Optional<Room> ro = Optional.ofNullable(roomService.getUserById(id));
		if(ro.isEmpty()) {
			model.addAttribute("message", "Room not found with id "+id);
			return "index";
		}else {
			model.addAttribute("room", ro.get());
		}
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String addStudent(
			@RequestParam("id") Integer id,
			@RequestParam("roomno") String roomno,
			@RequestParam("isEmpty") boolean isEmpty,
			@RequestParam("roomsize") String roomsize,
			@RequestParam("pricepernight") double pricepernight,
			@RequestParam("roomType") String roomType,
			@RequestParam("floor") Integer floor,
			@RequestParam("status") String status,
			RedirectAttributes redirectAttributes,
			Model model
			) {
		Optional<Room> rm = Optional.ofNullable(roomService.getUserById(id));
		if(rm.isEmpty()) {
			model.addAttribute("error", "Something went wrong :(");
			return null;
		}else {
			rm.get().setRoomno(roomno);
			rm.get().setEmpty(isEmpty);
			rm.get().setRoomsize(roomsize);
			rm.get().setPricepernight(pricepernight);
			rm.get().setRoomType(roomType);
			rm.get().setFloor(floor);
			rm.get().setStatus(status);
			model.addAttribute("message", rm.get().getRoomno()+" Updated Successfully :)");
			roomService.updateRoom(rm.get());
			
		}
		return "index";
	}
	
	
}
