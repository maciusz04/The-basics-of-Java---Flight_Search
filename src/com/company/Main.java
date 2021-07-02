package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	FlightDatabase base = new FlightDatabase();
	base.checkIfFlightExists("Paris", "Madrid");
	base.displayFlightsFromCity("Paris");
	base.displayFlightsToCity("Warsaw");
	base.displayAllCities();

    }
}

