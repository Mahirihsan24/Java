import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AirlineReservationSystem extends JFrame {
    private HashMap<Integer, Flight> flights;
    private JTextField flightNumberField;
    private JTextField originField;
    private JTextField destinationField;
    private JTextField departureDateField;
    private JTextField arrivalDateField;
    private JComboBox<FlightClass> flightClassComboBox;
    private JButton addFlightButton;
    private JButton displayFlightsButton;
    private JButton cancelFlightButton;
    private JTextArea flightsTextArea;

    private JTextField passengerNameField;
    private JTextField passengerPassportNumberField;
    private JComboBox<FlightClass> passengerFlightClassComboBox;
    private JButton bookPassengerButton;
    private JTextArea bookingDetailsTextArea;

    public AirlineReservationSystem() {
        flights = new HashMap<>();

        // Create GUI components
        flightNumberField = new JTextField(10);
        originField = new JTextField(10);
        destinationField = new JTextField(10);
        departureDateField = new JTextField(10);
        arrivalDateField = new JTextField(10);
        flightClassComboBox = new JComboBox<>(FlightClass.values());
        addFlightButton = new JButton("Add Flight");
        displayFlightsButton = new JButton("Display Flights");
        cancelFlightButton = new JButton("Cancel Flight");
        flightsTextArea = new JTextArea(10, 20);

        passengerNameField = new JTextField(10);
        passengerPassportNumberField = new JTextField(10);
        passengerFlightClassComboBox = new JComboBox<>(FlightClass.values());
        bookPassengerButton = new JButton("Book Passenger");
        bookingDetailsTextArea = new JTextArea(10, 20);

        // Add action listeners to buttons
        addFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlight();
            }
        });
        displayFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFlights();
            }
        });
        cancelFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelFlight();
            }
        });
        bookPassengerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookPassenger();
            }
        });

        // Create GUI layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Flight Number:"));
        panel.add(flightNumberField);
        panel.add(new JLabel("Origin:"));
        panel.add(originField);
        panel.add(new JLabel("Destination:"));
        panel.add(destinationField);
        panel.add(new JLabel("Departure Date:"));
        panel.add(departureDateField);
        panel.add(new JLabel("Arrival Date:"));
        panel.add(arrivalDateField);
        panel.add(new JLabel("Flight Class:"));
        panel.add(flightClassComboBox);
        panel.add(addFlightButton);
        panel.add(displayFlightsButton);
        panel.add(cancelFlightButton);
        panel.add(new JScrollPane(flightsTextArea));

        JPanel passengerPanel = new JPanel();
        passengerPanel.setLayout(new BoxLayout(passengerPanel, BoxLayout.Y_AXIS));
        passengerPanel.add(new JLabel("Passenger Name:"));
        passengerPanel.add(passengerNameField);
        passengerPanel.add(new JLabel("Passport Number:"));
        passengerPanel.add(passengerPassportNumberField);
        passengerPanel.add(new JLabel("Flight Class:"));
        passengerPanel.add(passengerFlightClassComboBox);
        passengerPanel.add(bookPassengerButton);
        passengerPanel.add(new JScrollPane(bookingDetailsTextArea));

        // Add panels to frame
        add(panel, BorderLayout.NORTH);
        add(passengerPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addFlight() {
        int flightNumber = Integer.parseInt(flightNumberField.getText());
        String origin = originField.getText();
        String destination = destinationField.getText();
        String departureDateStr = departureDateField.getText();
        String arrivalDateStr = arrivalDateField.getText();
        FlightClass flightClass = (FlightClass) flightClassComboBox.getSelectedItem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date departureDate = null;
        Date arrivalDate = null;
        try {
            departureDate = sdf.parse(departureDateStr);
            arrivalDate = sdf.parse(arrivalDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        Flight flight = new Flight(flightNumber, origin, destination, departureDate, arrivalDate, flightClass);
        flights.put(flightNumber, flight);

        flightNumberField.setText("");
        originField.setText("");
        destinationField.setText("");
        departureDateField.setText("");
        arrivalDateField.setText("");
    }

    private void displayFlights() {
        flightsTextArea.setText("");
        if (flights.isEmpty()) {
            flightsTextArea.append("No flights available.");
        } else {
            for (Flight flight : flights.values()) {
                flightsTextArea.append("Flight Number: " + flight.getFlightNumber() + "\n");
                flightsTextArea.append("Origin: " + flight.getOrigin() + "\n");
                flightsTextArea.append("Destination: " + flight.getDestination() + "\n");
                flightsTextArea.append("Departure Date: " + flight.getDepartureDate() + "\n");
                flightsTextArea.append("Arrival Date: " + flight.getArrivalDate() + "\n");
                flightsTextArea.append("Flight Class: " + flight.getFlightClass() + "\n\n");
            }
        }
    }

    private void cancelFlight() {
        int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number to cancel:"));
        if (flights.containsKey(flightNumber)) {
            flights.remove(flightNumber);
            JOptionPane.showMessageDialog(null, "Flight " + flightNumber + " cancelled.");
        } else {
            JOptionPane.showMessageDialog(null, "Flight " + flightNumber + " not found.");
        }
    }

    private void bookPassenger() {
    String passengerName = passengerNameField.getText();
    String passportNumber = passengerPassportNumberField.getText();
    int flightNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter flight number:"));
    String origin = JOptionPane.showInputDialog("Enter origin:");
    String destination = JOptionPane.showInputDialog("Enter destination:");
    String bookByName = JOptionPane.showInputDialog("Do you want to book by name? (yes/no)");

    if (bookByName.equalsIgnoreCase("yes")) {
        String name = JOptionPane.showInputDialog("Enter name:");
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                flight.addPassenger(new Passenger(passengerName, passportNumber));
                bookingDetailsTextArea.setText("Passenger " + passengerName + " booked on flight " + flightNumber);
            } else {
                bookingDetailsTextArea.setText("Flight not found with the given origin and destination.");
            }
        } else {
            bookingDetailsTextArea.setText("Flight not found.");
        }
    } else {
        if (flights.containsKey(flightNumber)) {
            Flight flight = flights.get(flightNumber);
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination)) {
                flight.addPassenger(new Passenger(passengerName, passportNumber));
                bookingDetailsTextArea.setText("Passenger " + passengerName + " booked on flight " + flightNumber);
            } else {
                bookingDetailsTextArea.setText("Flight not found with the given origin and destination.");
            }
        } else {
            bookingDetailsTextArea.setText("Flight not found.");
        }
    }

    passengerNameField.setText("");
    passengerPassportNumberField.setText("");
}

    public static void main(String[] args) {
        new AirlineReservationSystem();
    }
}
