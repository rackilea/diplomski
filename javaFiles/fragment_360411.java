public class Table {

public List<Car> getTableConnection() throws ClassNotFoundException, SQLException {
    Work work = new Work();
    ResultSet result = null;
    Statement sp = null;
    Connection conn = null;
    ResultSet rs = null;
    List<Car> cars = new ArrayList<>();

    try {
        **conn =work.createConnection();**
        sp = conn.createStatement();
        conn.setAutoCommit(false);
        result = sp.executeQuery("SELECT * FROM cardetails");
        while (result.next()) {
            Car car = new Car();
            car.setId(result.getInt("id"));
            car.setYear(result.getString("Year"));
            car.setMake(result.getString("Make"));
            car.setModel(result.getString("Model"));
            car.setColor(result.getString("Color"));
            car.setAvailable(result.getString("Availability"));
            cars.add(car);
        }
    } catch (Exception e) {

    } finally {

    }
    return cars;
}