public class Car extends Vehicle {

    private String name = "Car";
    private int size = 1;

    public Car() {
        this.passengers = random.nextInt(4) + 1;
    }

}