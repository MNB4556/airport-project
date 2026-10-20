# Brunel Airport Departure Management System

A comprehensive Java application for managing airport flight departures. Developed as part of a collaborative group project focusing on the departure module with real-time flight status updates, passenger management, and scheduling features.

## Features

- **Flight Management**: Add, search, update, and remove flights
- **Real-time Status Updates**: Update flight status (On Time, Delayed, Boarding, Departed)
- **Gate Management**: Assign and update gate assignments
- **Flight Filtering**: Filter flights by status or destination
- **Upcoming Flights**: View flights departing in the next 3 hours
- **Statistics Dashboard**: View flight and passenger statistics
- **Modular Architecture**: Clean OOP design with separation of concerns
- **Comprehensive Error Handling**: Robust input validation and error messages

## Requirements

- Java 8 or higher
- Eclipse IDE (recommended) or any Java IDE

## Building the Project

### Using Command Line:

```bash
cd src
javac *.java
java AirportDepartureSystem
```

### Using Eclipse IDE:

1. Import the project into Eclipse
2. Right-click on `AirportDepartureSystem.java`
3. Select "Run As" > "Java Application"

## Project Structure

```
airport-project/
├── src/
│   ├── Flight.java              # Flight entity class
│   ├── FlightManager.java       # Flight management logic
│   └── AirportDepartureSystem.java  # Main application
└── README.md                    # This file
```

## Usage

1. Run the application
2. Use the menu to navigate through options:
   - View all departing flights
   - Search for specific flights
   - Add new flights
   - Update flight status
   - Update gate assignments
   - View flights by status
   - View upcoming flights
   - View statistics

## Technologies Used

- Java (OOP principles)
- Eclipse IDE
- Git for version control
- MySQL database ready (structure prepared)

## Key Features Implementation

- **Flight Scheduling System**: Complete CRUD operations for flights
- **Real-time Updates**: Dynamic status and gate management
- **Database Integration**: Structure ready for MySQL integration
- **User Authentication**: Framework for authentication system
- **Modular Architecture**: Easy to extend and maintain
- **Comprehensive Error Handling**: Graceful error handling throughout

## Sample Data

The system comes with sample flights pre-loaded:
- BA101 to New York
- LH205 to Frankfurt
- AF310 to Paris
- EK420 to Dubai
- VS550 to London
- QF670 to Sydney

## Future Enhancements

- Database integration (MySQL)
- GUI interface (JavaFX/Swing)
- Real-time notifications
- Web interface
- Mobile app integration
- Advanced reporting features

