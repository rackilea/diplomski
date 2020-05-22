public class Vehicle {

    protected int capacity;
    protected String make;

    public Vehicle(int capacity, String make) {
        this.capacity = capacity;
        this.make = make;
    }

    public void print() {
        System.out.println("Capacity: " + capacity);
        System.out.println("Make: " + make);
    }
}