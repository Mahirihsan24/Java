import java.util.ArrayList;
import java.util.Date;

public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private FlightClass flightClass;
    private ArrayList<Passenger> passengers;

    public Flight(int flightNumber, String origin, String destination, Date departureDate, Date arrivalDate, FlightClass flightClass) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.flightClass = flightClass;
        this.passengers = new ArrayList<>();
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }
}