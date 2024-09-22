import java.util.ArrayList;

public class AirlineReservationSystem {
    private ArrayList<Flight> flights;

    public AirlineReservationSystem() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void displayFlights() {
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Origin: " + flight.getOrigin());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Departure Date: " + flight.getDepartureDate());
            System.out.println("Arrival Date: " + flight.getArrivalDate());
            System.out.println("Flight Class: " + flight.getFlightClass());
            System.out.println("Flight Status: " + flight.getFlightStatus());
            System.out.println("Passengers:");
            for (Passenger passenger : flight.getPassengers()) {
                System.out.println("  " + passenger.getName() + " (" + passenger.getPassportNumber() + ")");
            }
            System.out.println();
        }
    }

    public void bookFlight(int flightNumber, Passenger passenger) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                flight.addPassenger(passenger);
                System.out.println("Passenger " + passenger.getName() + " booked on flight " + flightNumber);
                return;
            }
        }
        System.out.println("Flight not found");
    }

    public void cancelFlight(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                flight.setFlightStatus(FlightStatus.CANCELED);
                System.out.println("Flight " + flightNumber + " canceled");
                return;
            }
        }
        System.out.println("Flight not found");
    }
}