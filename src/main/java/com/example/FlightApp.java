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
            System.out.println("\nFlight: " + flight.getFlightNumber() + " | Available Seats: " + flight.getAvailableSeats());
            System.out.println("1. View Flight Availability");
            System.out.println("2. Book Seats");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.printf("Total: %d | Booked: %d | Available: %d | Base Price: $%.2f%n",
                            flight.getTotalSeats(), flight.getBookedSeats(), flight.getAvailableSeats(), flight.getBasePrice());
                    break;
                case "2":
                    System.out.print("Enter number of seats to book: ");
                    try {
                        int seats = Integer.parseInt(scanner.nextLine());
                        flight.bookSeats(seats);
                        System.out.println("Seats booked! Remaining: " + flight.getAvailableSeats());
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.println("Exiting Flight System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
