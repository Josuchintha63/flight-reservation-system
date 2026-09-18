package com.example;

public class FlightBooking {
    private String flightNumber;
    private int totalSeats;
    private int bookedSeats;
    private double basePrice;

    public FlightBooking(String flightNumber, int totalSeats, int bookedSeats, double basePrice) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.bookedSeats = bookedSeats;
        this.basePrice = basePrice;
    }

    public String getFlightNumber() { return flightNumber; }
    public int getTotalSeats() { return totalSeats; }
    public int getBookedSeats() { return bookedSeats; }
    public double getBasePrice() { return basePrice; }

    public int getAvailableSeats() {
        return this.totalSeats - this.bookedSeats;
    }

    // BUG: Allows overbooking beyond capacity
    public void bookSeats(int seats) {
        this.bookedSeats += seats;
    }

    // BUG: Incorrect baggage charge multiplier
    public double calculateTotalBookingCost(int seats, double baggageWeightKg) {
        double seatCost = seats * this.basePrice;
        double baggageCost = baggageWeightKg * 2.0; // Incorrect flat rate
        return seatCost + baggageCost;
    }
}
