public class Car {
    private String make;
    private int year;
    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }    

    @Overrride
    public String toString() {
        return "Car Make:" + make + "; Built Year: " + year;
    }
}