package com.proair.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proair.service.SeatAllocate;

@RestController
@RequestMapping("/book")
public class BookingApi {

	@Autowired
	SeatAllocate seatAllocate;
	
	@GetMapping("/allocate/{number}")
	public void allocate(@PathVariable int number) {
		seatAllocate.allocate(number);
	}

	@GetMapping("/get")
	public void display() {
		seatAllocate.display();
	}
}
