import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FlightManager {
    private List<Flight> flights;
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    
    public FlightManager() {
        this.flights = new ArrayList<>();
        initializeSampleFlights();
    }
    
    private void initializeSampleFlights() {
        // Add sample flights
        flights.add(new Flight("BA101", "New York", "08:30", "A12", "On Time", 180, "Boeing 777"));
        flights.add(new Flight("LH205", "Frankfurt", "09:15", "B05", "Boarding", 220, "Airbus A380"));
        flights.add(new Flight("AF310", "Paris", "10:00", "C08", "On Time", 150, "Airbus A320"));
        flights.add(new Flight("EK420", "Dubai", "11:45", "D15", "Delayed", 300, "Boeing 777"));
        flights.add(new Flight("VS550", "London", "12:30", "A03", "On Time", 250, "Boeing 787"));
        flights.add(new Flight("QF670", "Sydney", "14:20", "E22", "On Time", 280, "Airbus A380"));
    }
    
    public void addFlight(Flight flight) {
        flights.add(flight);
        sortFlightsByTime();
    }
    
    public boolean removeFlight(String flightNumber) {
        return flights.removeIf(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }
    
    public Flight findFlight(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst()
                .orElse(null);
    }
    
    public void updateFlightStatus(String flightNumber, String newStatus) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            flight.setStatus(newStatus);
        }
    }
    
    public void updateGate(String flightNumber, String newGate) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            flight.setGate(newGate);
        }
    }
    
    public List<Flight> getFlightsByStatus(String status) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getStatus().equalsIgnoreCase(status)) {
                result.add(flight);
            }
        }
        return result;
    }
    
    public List<Flight> getFlightsByDestination(String destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                result.add(flight);
            }
        }
        return result;
    }
    
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }
    
    public List<Flight> getUpcomingFlights(int hours) {
        List<Flight> result = new ArrayList<>();
        LocalTime now = LocalTime.now();
        LocalTime future = now.plusHours(hours);
        
        for (Flight flight : flights) {
            try {
                LocalTime depTime = LocalTime.parse(flight.getDepartureTime(), timeFormatter);
                if (depTime.isAfter(now) && depTime.isBefore(future)) {
                    result.add(flight);
                }
            } catch (Exception e) {
                // Skip invalid time formats
            }
        }
        return result;
    }
    
    private void sortFlightsByTime() {
        flights.sort((f1, f2) -> {
            try {
                LocalTime t1 = LocalTime.parse(f1.getDepartureTime(), timeFormatter);
                LocalTime t2 = LocalTime.parse(f2.getDepartureTime(), timeFormatter);
                return t1.compareTo(t2);
            } catch (Exception e) {
                return 0;
            }
        });
    }
    
    public int getTotalPassengers() {
        return flights.stream().mapToInt(Flight::getPassengerCount).sum();
    }
    
    public Map<String, Integer> getFlightCountByStatus() {
        Map<String, Integer> statusCount = new HashMap<>();
        for (Flight flight : flights) {
            statusCount.put(flight.getStatus(), 
                    statusCount.getOrDefault(flight.getStatus(), 0) + 1);
        }
        return statusCount;
    }
}

