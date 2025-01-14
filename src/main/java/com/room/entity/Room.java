package com.room.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true, nullable = false)
	private String roomno;
	
	private boolean isEmpty;
	
	private String roomsize;
	
	private double pricepernight;
	
	private String roomType;
	
	private Integer floor;
	
	private String status;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String roomno, boolean isEmpty, String roomsize, double pricepernight, String roomType, Integer floor,
			String status) {
		super();
		this.roomno = roomno;
		this.isEmpty = isEmpty;
		this.roomsize = roomsize;
		this.pricepernight = pricepernight;
		this.roomType = roomType;
		this.floor = floor;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomno() {
		return roomno;
	}

	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getRoomsize() {
		return roomsize;
	}

	public void setRoomsize(String roomsize) {
		this.roomsize = roomsize;
	}

	public double getPricepernight() {
		return pricepernight;
	}

	public void setPricepernight(double pricepernight) {
		this.pricepernight = pricepernight;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}