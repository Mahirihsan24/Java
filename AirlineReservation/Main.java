import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem airlineReservationSystem = new AirlineReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add flight");
            System.out.println("2. Display flights");
            System.out.println("3. Book passenger");
            System.out.println("4. Cancel flight");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addFlight(airlineReservationSystem, scanner);
                    break;
                case 2:
                    airlineReservationSystem.displayFlights();
                    break;
                case 3:
                    bookFlight(airlineReservationSystem, scanner);
                    break;
                case 4:
                    cancelFlight(airlineReservationSystem, scanner);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void addFlight(AirlineReservationSystem airlineReservationSystem, Scanner scanner) {
        System.out.print("Enter flight number: ");
        int flightNumber = scanner.nextInt();
        System.out.print("Enter origin: ");
        String origin = scanner.next();
        System.out.print("Enter destination: ");
        String destination = scanner.next();
        System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDateStr = scanner.next();
        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        String arrivalDateStr = scanner.next();
        System.out.print("Enter flight class (ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST_CLASS): ");
        String flightClassStr = scanner.next();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date departureDate = sdf.parse(departureDateStr);
            Date arrivalDate = sdf.parse(arrivalDateStr);
            FlightClass flightClass = FlightClass.valueOf(flightClassStr);

            Flight flight = new Flight(flightNumber, origin, destination, departureDate, arrivalDate, flightClass);
            airlineReservationSystem.addFlight(flight);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid flight class. Please use ECONOMY, PREMIUM_ECONOMY, BUSINESS, or FIRST_CLASS.");
        }
    }

    private static void bookFlight(AirlineReservationSystem airlineReservationSystem, Scanner scanner) {
        System.out.print("Enter flight number: ");
        int bookFlightNumber = scanner.nextInt();
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.next();
        System.out.print("Enter passenger passport number: ");
        String passportNumber = scanner.next();
        System.out.print("Enter flight class (ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST_CLASS): ");
        String bookFlightClassStr = scanner.next();

        try {
            FlightClass bookFlightClass = FlightClass.valueOf(bookFlightClassStr);

            Passenger passenger = new Passenger(passengerName, passportNumber, bookFlightClass);
            airlineReservationSystem.bookFlight(bookFlightNumber, passenger);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid flight class. Please use ECONOMY, PREMIUM_ECONOMY, BUSINESS, or FIRST_CLASS.");
        }
    }

    private static void cancelFlight(AirlineReservationSystem airlineReservationSystem, Scanner scanner) {
        System.out.print("Enter flight number: ");
        int cancelFlightNumber = scanner.nextInt();
        airlineReservationSystem.cancelFlight(cancelFlightNumber);
    }
}