public class Passenger {
    private String name;
    private String passportNumber;
    private FlightClass flightClass;

    public Passenger(String name, String passportNumber, FlightClass flightClass) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.flightClass = flightClass;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }
}