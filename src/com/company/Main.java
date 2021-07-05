package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	FlightDatabase base = new FlightDatabase();
	base.checkIfFlightExists("Paris", "Madrid");
	base.displayFlightsFromCity("Paris");
	base.displayFlightsToCity("Warsaw");
	base.displayAllCities();
	Flight cheapestFlight = base.getCheapestFlight();
	System.out.println("Cheapest flight: " + cheapestFlight.getInfo());
	cheapestFlight = base.getCheapestFlightFromCity("Warsaw");
	System.out.println("Cheapest flight: " +cheapestFlight.getInfo() + "\n\n");
	ArrayList<Journey> journeys = base.getFlights("Paris", "Porto");
	System.out.println(journeys);

    }
}

