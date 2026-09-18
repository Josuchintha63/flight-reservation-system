package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightBookingTest {

    private FlightBooking flight;

    @BeforeEach
    void setUp() {
        flight = new FlightBooking("AI-404", 100, 80, 200.0);
    }

    @Test
    @DisplayName("Should correctly calculate available seats")
    void testAvailableSeats() {
        assertEquals(20, flight.getAvailableSeats());
    }

    @Test
    @DisplayName("Should successfully book valid seats within capacity")
    void testBookSeatsSuccess() {
        flight.bookSeats(10);
        assertEquals(90, flight.getBookedSeats());
        assertEquals(10, flight.getAvailableSeats());
    }

    @Test
    @DisplayName("Should throw exception when overbooking beyond available seats")
    void testOverbookingRejection() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> flight.bookSeats(25));
        assertTrue(ex.getMessage().contains("Not enough seats available"));
    }

    @Test
    @DisplayName("Should compute booking cost with $15/kg for baggage exceeding 15kg allowance")
    void testBaggageAllowanceFee() {
        // 2 seats * 200 = 400; 20kg baggage (5kg excess * 15 = 75); Total = 475
        double cost = flight.calculateTotalBookingCost(2, 20.0);
        assertEquals(475.0, cost, 0.001);
    }
}
