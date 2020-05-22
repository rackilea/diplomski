public class Car extends Vehicle {

    private String type;
    private String model;

    public Car(int capacity, String make, String type, String model) {
        super(capacity, make);
        this.type = type;
        this.model = model;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Type: " + type);
        System.out.println("Model: " + model);
    }
}