# Flight Reservation System

A Java 21 console application for managing flight seat bookings and baggage calculation.

---

## Requirements
- Java 21+
- Apache Maven 3.8+

---

## How to Build & Run
```bash
mvn clean compile
mvn exec:java
```

---

## Running Tests
```bash
mvn test
```

---

## Issue Tracking & Git Workflow

### Jira Workspace: [Flight Reservation System (FRS)](https://chinthajyoshna.atlassian.net/browse/FRS-1)
- **Ticket Key**: `FRS-1`
- **Summary**: Fix Flight Booking seat availability and baggage fee calculation bug
- **Status**: Resolved / In Progress
- **Branch**: `FRS-1` & `FRS-123`

### Commit History for FRS-1:
1. `test(FRS-1): add unit tests reproducing overbooking capacity and baggage fee bugs`
2. `fix(FRS-1): implement validation for flight capacity and base pricing`
3. `fix(FRS-1): prevent overbooking beyond capacity and correct baggage allowance fee formula`
4. `refactor(FRS-1): enhance flight booking UI with fare and luggage summary`
5. `docs(FRS-1): update README with bug resolution details, test results, and Jira ticket FRS-1`

---

## GitHub Repository
- **Owner**: [Josuchintha63](https://github.com/Josuchintha63)
- **Repository**: [https://github.com/Josuchintha63/flight-reservation-system](https://github.com/Josuchintha63/flight-reservation-system)
