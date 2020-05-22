// My hardware interface
private Thermostat thermostat;

// My temperature DB tables interface
private TemperatureDAO temperatureDAO;

public Controller() {
    thermostat = new Thermostat();
    temperatureDAO = new TemperatureDAO();     
    // As the controller, I get to decide what connection the application uses.
    temperatureDAO.setConnection(new ConnectionProvider().getConnection());
}