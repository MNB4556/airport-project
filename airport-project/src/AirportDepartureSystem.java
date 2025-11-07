import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AirportDepartureSystem {
    private FlightManager flightManager;
    private Scanner scanner;
    
    public AirportDepartureSystem() {
        this.flightManager = new FlightManager();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║   Brunel Airport - Departure Management System       ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    displayAllFlights();
                    break;
                case 2:
                    searchFlight();
                    break;
                case 3:
                    addFlight();
                    break;
                case 4:
                    updateFlightStatus();
                    break;
                case 5:
                    updateGate();
                    break;
                case 6:
                    viewFlightsByStatus();
                    break;
                case 7:
                    viewUpcomingFlights();
                    break;
                case 8:
                    viewStatistics();
                    break;
                case 9:
                    running = false;
                    System.out.println("\nThank you for using the Airport Departure System. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private void displayMainMenu() {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("                    MAIN MENU");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("1. View All Departures");
        System.out.println("2. Search for a Flight");
        System.out.println("3. Add New Flight");
        System.out.println("4. Update Flight Status");
        System.out.println("5. Update Gate Assignment");
        System.out.println("6. View Flights by Status");
        System.out.println("7. View Upcoming Flights (Next 3 Hours)");
        System.out.println("8. View Statistics");
        System.out.println("9. Exit");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.print("Enter your choice: ");
    }
    
    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void displayAllFlights() {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("              ALL DEPARTING FLIGHTS");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        List<Flight> flights = flightManager.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("No flights scheduled.");
        } else {
            System.out.printf("%-10s %-20s %-10s %-8s %-12s %-10s %-15s%n",
                    "Flight", "Destination", "Time", "Gate", "Status", "Passengers", "Aircraft");
            System.out.println("────────────────────────────────────────────────────────────────────────────────────");
            for (Flight flight : flights) {
                System.out.printf("%-10s %-20s %-10s %-8s %-12s %-10d %-15s%n",
                        flight.getFlightNumber(),
                        flight.getDestination(),
                        flight.getDepartureTime(),
                        flight.getGate(),
                        flight.getStatus(),
                        flight.getPassengerCount(),
                        flight.getAircraftType());
            }
        }
    }
    
    private void searchFlight() {
        System.out.print("\nEnter flight number to search: ");
        String flightNumber = scanner.nextLine().trim();
        
        Flight flight = flightManager.findFlight(flightNumber);
        if (flight != null) {
            System.out.println("\n═══════════════════════════════════════════════════════════");
            System.out.println("                    FLIGHT DETAILS");
            System.out.println("═══════════════════════════════════════════════════════════");
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Departure Time: " + flight.getDepartureTime());
            System.out.println("Gate: " + flight.getGate());
            System.out.println("Status: " + flight.getStatus());
            System.out.println("Passengers: " + flight.getPassengerCount());
            System.out.println("Aircraft Type: " + flight.getAircraftType());
        } else {
            System.out.println("\nFlight not found: " + flightNumber);
        }
    }
    
    private void addFlight() {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("              ADD NEW FLIGHT");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        System.out.print("Flight Number: ");
        String flightNumber = scanner.nextLine().trim();
        
        System.out.print("Destination: ");
        String destination = scanner.nextLine().trim();
        
        System.out.print("Departure Time (HH:mm): ");
        String departureTime = scanner.nextLine().trim();
        
        System.out.print("Gate: ");
        String gate = scanner.nextLine().trim();
        
        System.out.print("Status (On Time/Delayed/Boarding/Departed): ");
        String status = scanner.nextLine().trim();
        
        System.out.print("Passenger Count: ");
        int passengerCount = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("Aircraft Type: ");
        String aircraftType = scanner.nextLine().trim();
        
        Flight newFlight = new Flight(flightNumber, destination, departureTime,
                gate, status, passengerCount, aircraftType);
        flightManager.addFlight(newFlight);
        
        System.out.println("\n✓ Flight " + flightNumber + " added successfully!");
    }
    
    private void updateFlightStatus() {
        System.out.print("\nEnter flight number: ");
        String flightNumber = scanner.nextLine().trim();
        
        Flight flight = flightManager.findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found: " + flightNumber);
            return;
        }
        
        System.out.println("Current status: " + flight.getStatus());
        System.out.print("New status (On Time/Delayed/Boarding/Departed): ");
        String newStatus = scanner.nextLine().trim();
        
        flightManager.updateFlightStatus(flightNumber, newStatus);
        System.out.println("\n✓ Flight status updated successfully!");
    }
    
    private void updateGate() {
        System.out.print("\nEnter flight number: ");
        String flightNumber = scanner.nextLine().trim();
        
        Flight flight = flightManager.findFlight(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found: " + flightNumber);
            return;
        }
        
        System.out.println("Current gate: " + flight.getGate());
        System.out.print("New gate: ");
        String newGate = scanner.nextLine().trim();
        
        flightManager.updateGate(flightNumber, newGate);
        System.out.println("\n✓ Gate assignment updated successfully!");
    }
    
    private void viewFlightsByStatus() {
        System.out.print("\nEnter status to filter (On Time/Delayed/Boarding/Departed): ");
        String status = scanner.nextLine().trim();
        
        List<Flight> flights = flightManager.getFlightsByStatus(status);
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("        FLIGHTS WITH STATUS: " + status.toUpperCase());
        System.out.println("═══════════════════════════════════════════════════════════");
        
        if (flights.isEmpty()) {
            System.out.println("No flights found with status: " + status);
        } else {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        }
    }
    
    private void viewUpcomingFlights() {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("        UPCOMING FLIGHTS (NEXT 3 HOURS)");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        List<Flight> upcoming = flightManager.getUpcomingFlights(3);
        if (upcoming.isEmpty()) {
            System.out.println("No upcoming flights in the next 3 hours.");
        } else {
            for (Flight flight : upcoming) {
                System.out.println(flight);
            }
        }
    }
    
    private void viewStatistics() {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("                    STATISTICS");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        List<Flight> allFlights = flightManager.getAllFlights();
        System.out.println("Total Flights: " + allFlights.size());
        System.out.println("Total Passengers: " + flightManager.getTotalPassengers());
        
        Map<String, Integer> statusCount = flightManager.getFlightCountByStatus();
        System.out.println("\nFlights by Status:");
        for (Map.Entry<String, Integer> entry : statusCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        AirportDepartureSystem system = new AirportDepartureSystem();
        system.run();
    }
}

