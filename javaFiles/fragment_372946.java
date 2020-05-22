public class Car implements Serializable {

    private String make;
    private String model;
    private String year;
    private String odometer;

    public Car(){}

    public Car(String year, String odometer, String make, String model)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = odometer;
    }
}