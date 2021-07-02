package com.company;

class Flight{
    String departure;
    String arrival;
    public Flight(String departure, String arrival){
        this.arrival = arrival;
        this.departure = departure;
    }
    public String getInfo(){
        return "Flight from " + this.departure + " to " + this.arrival;
    }


}