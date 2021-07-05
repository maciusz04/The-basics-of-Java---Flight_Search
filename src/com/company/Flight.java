package com.company;

class Flight{
    String departure;
    String arrival;
    int price;

    public Flight(String departure, String arrival, int price){
        this.arrival = arrival;
        this.departure = departure;
        this.price = price;
    }
    public String getInfo(){
        return "Flight from " + this.departure + " to " + this.arrival + " costs " + this.price;
    }


}