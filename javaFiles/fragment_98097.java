@JsonIgnoreProperties({ // any properties from parent that can be ignored })
public class Car extends Vehicle {
    // any properties from this class to be ignored place it above the property
    @JsonIgnore
    private int seatingCapacity;
    private double topSpeed;

    public Car(String make, String model, int seatingCapacity, double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }

    // no-arg constructor, getters and setters
}