package edu.mum.roomsys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	@Id
	@GeneratedValue
	private int id;

	@Column(length = 4, nullable = false)
	private int buildNumber;

	@Column(length = 4, nullable = false)
	private int number;

	@Enumerated(EnumType.STRING)
	@Column(length = 100, nullable = false)
	private RoomStatus status;

	@JsonIgnore
	@OneToOne(mappedBy = "room", fetch = FetchType.EAGER)
	private RoomItem item;

	@JsonIgnore
	@OneToMany(mappedBy = "room")
	private List<Booking> bookings;

	public Room() {
		super();
		bookings = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public RoomItem getItem() {
		return item;
	}

	public void setItem(RoomItem item) {
		this.item = item;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	
}
