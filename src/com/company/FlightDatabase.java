package com.company;

import java.util.ArrayList;

public class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabase() {
        flights.add(new Flight("Berlin", "Tokio", 1800));
        flights.add(new Flight("Paris", "Berlin", 79));
        flights.add(new Flight("Warsaw", "Paris", 120));
        flights.add(new Flight("Madrid", "Berlin",200));
        flights.add(new Flight("Berlin", "Warsaw", 77));
        flights.add(new Flight("Paris", "Madrid", 180));
        flights.add(new Flight("Porto", "Warsaw", 412));
        flights.add(new Flight("Madrid", "Porto", 102));
        flights.add(new Flight("Warsaw", "Madrid", 380));
    }

    public boolean checkIfFlightExists(String start, String end) {
        for (int i = 0; i < this.flights.size(); i++) {
            if (start.equals(this.flights.get(i).departure) && end.equals(this.flights.get(i).arrival)) {
                System.out.println("Flight exists");
                return true;
            }
        }
        return false;
    }

    public ArrayList<Flight> getFlightsFromCity(String city) {
        ArrayList<Flight> flightsList = new ArrayList<Flight>();

        for (int i = 0; i < this.flights.size(); i++) {
            if (city.equals(flights.get(i).departure)) {
                Flight flight = this.flights.get(i);
                flightsList.add(flight);
            }

        }
        return flightsList;
    }

    public ArrayList<Flight> getFlightsToCity(String cityEnd){
        ArrayList<Flight> flightsList = new ArrayList<Flight>();
        for(int i=0; i<this.flights.size(); i++){
            Flight flight = this.flights.get(i);
            if(cityEnd.equals(flight.arrival)){
                flightsList.add(flight);
            }
        }
       return flightsList;
    }

    public void displayFlights (ArrayList<Flight> results){
        if(results.isEmpty()){
            System.out.println("Flight not found");
        }
        for (Flight flight : results){
            System.out.println(flight.getInfo());
        }
    }

    public void displayFlightsFromCity(String city){
        ArrayList<Flight> fromCity = getFlightsFromCity(city);
        displayFlights(fromCity);
    }

    public void displayFlightsToCity(String city){
        ArrayList<Flight> toCity = getFlightsToCity(city);
        displayFlights(toCity);
    }

    public ArrayList<String> getCities(){
        ArrayList<String> listOfCities  = new ArrayList<String>();
        for(Flight flight : this.flights){
            if(!listOfCities.contains(flight.departure)){
                listOfCities.add(flight.departure);
            }
            if(!listOfCities.contains(flight.arrival)){
                listOfCities.add(flight.arrival);
            }
        }
        return listOfCities;
    }

    public void displayAllCities(){
        ArrayList<String> listOfCities = getCities();
        for(String flight : listOfCities){
            System.out.print(flight + " ");
        }
        System.out.println();
    }

    public Flight getCheapestFlight() {
        Flight cheapestFlight = null;
        for(Flight flight : flights){
            if(cheapestFlight==null || flight.price<cheapestFlight.price)
                cheapestFlight=flight;
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city){
        Flight cheapestFromCity = null;
        ArrayList <Flight> cities = new ArrayList<>();
        cities = getFlightsFromCity(city);
        if(cities!=null){
            for(Flight flight : cities){
                if(cheapestFromCity==null || flight.price< cheapestFromCity.price)
                    cheapestFromCity=flight;
            }
        }

        return cheapestFromCity;
    }

    public ArrayList<Journey> getFlights(String start, String end){
        ArrayList<Flight> startCities =  getFlightsFromCity(start);
        ArrayList<Flight> endCities = getFlightsToCity(end);
        ArrayList<Journey> results = new ArrayList<Journey>();
        for(Flight flight : startCities){
            for(Flight flight1 : endCities){
                if(flight.arrival.equals(flight1.departure)){
                    results.add(new Journey(flight, flight1));
                }
            }
        }
        return results;
    }
    }
