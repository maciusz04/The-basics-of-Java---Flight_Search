package com.company;

import java.util.ArrayList;

public class FlightDatabase {
    ArrayList<Flight> flights = new ArrayList<Flight>();

    public FlightDatabase() {
        flights.add(new Flight("Berlin", "Tokio"));
        flights.add(new Flight("Paris", "Berlin"));
        flights.add(new Flight("Warsaw", "Paris"));
        flights.add(new Flight("Madrid", "Berlin"));
        flights.add(new Flight("Berlin", "Warsaw"));
        flights.add(new Flight("Paris", "Madrid"));
        flights.add(new Flight("Porto", "Warsaw"));
        flights.add(new Flight("Madrid", "Porto"));
        flights.add(new Flight("Warsaw", "Madrid"));
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
        for (int i=0; i<results.size(); i++){
            Flight flight = results.get(i);
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
        for(int i=0; i<this.flights.size(); i++){
            String city = flights.get(i).departure;
            if(!listOfCities.contains(city)){
                listOfCities.add(city);
            }
            city = flights.get(i).arrival;
            if(!listOfCities.contains(city)){
                listOfCities.add(city);
            }
        }
        return listOfCities;
    }

    public void displayAllCities(){
        ArrayList<String> listOfCities = getCities();
        for(int i=0; i<listOfCities.size(); i++){
            System.out.print(listOfCities.get(i) + " ");
        }
        System.out.println();
    }
    }
