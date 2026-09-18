package com.example;

import java.util.Scanner;

public class FlightApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("     Flight Booking & Reservation CLI    ");
        System.out.println("=========================================");

        FlightBooking flight = new FlightBooking("AI-404", 100, 85, 250.0);

        boolean running = true;
        while (running) {
            System.out.println("\n-----------------------------------------");
            System.out.println("Flight: " + flight.getFlightNumber() + " | Available Seats: " + flight.getAvailableSeats());
            System.out.println("-----------------------------------------");
            System.out.println("1. View Flight Status & Seating");
            System.out.println("2. Book Seats with Baggage Calculation");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("\n===== FLIGHT STATUS =====");
                    System.out.println("Flight Number   : " + flight.getFlightNumber());
                    System.out.println("Total Capacity  : " + flight.getTotalSeats());
                    System.out.println("Confirmed Seats : " + flight.getBookedSeats());
                    System.out.println("Available Seats : " + flight.getAvailableSeats());
                    System.out.printf("Base Ticket Fare: $%.2f%n", flight.getBasePrice());
                    System.out.println("=========================");
                    break;
                case "2":
                    try {
                        System.out.print("Enter number of seats to book: ");
                        int seats = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter total luggage weight in kg (15kg free): ");
                        double weight = Double.parseDouble(scanner.nextLine());
                        double totalFare = flight.calculateTotalBookingCost(seats, weight);
                        flight.bookSeats(seats);
                        System.out.printf("Booking Confirmed! Total Fare: $%.2f | Remaining Seats: %d%n",
                                totalFare, flight.getAvailableSeats());
                    } catch (Exception e) {
                        System.out.println("Booking Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Exiting Flight Reservation System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 3.");
            }
        }
        scanner.close();
    }
}
