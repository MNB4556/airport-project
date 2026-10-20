public class Flight {
    private String flightNumber;
    private String destination;
    private String departureTime;
    private String gate;
    private String status; // On Time, Delayed, Boarding, Departed
    private int passengerCount;
    private String aircraftType;
    
    public Flight(String flightNumber, String destination, String departureTime, 
                  String gate, String status, int passengerCount, String aircraftType) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        this.status = status;
        this.passengerCount = passengerCount;
        this.aircraftType = aircraftType;
    }
    
    // Getters and Setters
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    
    public String getGate() { return gate; }
    public void setGate(String gate) { this.gate = gate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getPassengerCount() { return passengerCount; }
    public void setPassengerCount(int passengerCount) { this.passengerCount = passengerCount; }
    
    public String getAircraftType() { return aircraftType; }
    public void setAircraftType(String aircraftType) { this.aircraftType = aircraftType; }
    
    @Override
    public String toString() {
        return String.format("%s | %s | %s | Gate %s | %s | %d passengers | %s",
                flightNumber, destination, departureTime, gate, status, passengerCount, aircraftType);
    }
}

