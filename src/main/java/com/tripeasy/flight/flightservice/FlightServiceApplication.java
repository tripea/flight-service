package com.tripeasy.flight.flightservice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tripeasy.flight.flightservice.entity.Flight;
import com.tripeasy.flight.flightservice.entity.Seat;
import com.tripeasy.flight.flightservice.repository.FlightRepository;

@SpringBootApplication
public class FlightServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner populateData(FlightRepository repository) {
		Flight flight1 = new Flight();
		flight1.setFlightId(3);
		flight1.setFlightName("AI-852 Updated");
		flight1.setAirline("Airjet");
		flight1.setSource("Pune");
		flight1.setDestination("Mumbai");
		flight1.setTime(LocalDateTime.now());

		List<Seat> seats = new ArrayList<Seat>();
		seats.add(new Seat("Economy", 1, 'C', true, 5000.00));
		seats.add(new Seat("Economy", 2, 'B', true, 2500.00));
		seats.add(new Seat("Economy", 2, 'A', true, 3500.00));
		flight1.setSeats(seats);

		return (args) -> {
			repository.save(flight1);
			repository.save(new Flight(1, "AI1203", "SpaceJet", "Pune", "Goa", LocalDateTime.now(), seats));
			repository.save(new Flight(2, "AI1204", "IndiGo", "Pune", "Goa", LocalDateTime.now(), seats));
			repository.save(new Flight(4, "AI1205", "IndiGo", "Mumbai", "Goa", LocalDateTime.now(), seats));
			repository.save(new Flight(5, "AI1206", "IndiGo", "Pune", "Mumbai", LocalDateTime.now(), seats));
		};
	}
}
