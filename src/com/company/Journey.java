package com.company;

public class Journey {
    Flight first;
    Flight second;

    public Journey (Flight first, Flight second){
        this.first = first;
        this.second = second;
    }
    public String toString(){
     return "Flight from " + first.departure + " to " + second.arrival + " with stop at "
     + first.arrival + " costs " + (first.price + second.price);
    }
}
