package com.example;

public class FlightBooking {
    private String flightNumber;
    private int totalSeats;
    private int bookedSeats;
    private double basePrice;

    public FlightBooking(String flightNumber, int totalSeats, int bookedSeats, double basePrice) {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty.");
        }
        if (totalSeats <= 0) {
            throw new IllegalArgumentException("Total seats must be greater than zero.");
        }
        if (bookedSeats < 0 || bookedSeats > totalSeats) {
            throw new IllegalArgumentException("Booked seats must be between 0 and total capacity.");
        }
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be greater than zero.");
        }
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

    public void bookSeats(int seats) {
        if (seats <= 0) {
            throw new IllegalArgumentException("Seats to book must be greater than zero.");
        }
        if (seats > getAvailableSeats()) {
            throw new IllegalArgumentException(
                String.format("Not enough seats available! Requested: %d, Available: %d", seats, getAvailableSeats())
            );
        }
        this.bookedSeats += seats;
    }

    public double calculateTotalBookingCost(int seats, double baggageWeightKg) {
        if (seats <= 0) {
            throw new IllegalArgumentException("Number of seats must be greater than zero.");
        }
        if (baggageWeightKg < 0) {
            throw new IllegalArgumentException("Baggage weight cannot be negative.");
        }
        double seatCost = seats * this.basePrice;
        double excessBaggage = Math.max(0.0, baggageWeightKg - 15.0); // 15kg free allowance
        double baggageCost = excessBaggage * 15.0; // $15 per excess kg
        return seatCost + baggageCost;
    }
}
