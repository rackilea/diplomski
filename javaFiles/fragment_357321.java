interface Vehicle {
    public start();
    public stop();
}

abstract class Car implements Vehicle {
    protected wheels = 4;

    public start() {
        loadPassengers();
        // do extra stuff like 
        //closeDoors();
    }

    abstract public loadPassengers();
}

public class Volvo extends Car {
    int passengers  =  6;

    public loadPassengers() {
         doSomething(this.passengers);
    }
}

public static void main() {
    List<Car> cars = new ArrayList<Car>();
    cars.add(new Volvo());
    cars.add(new Mercedes());

    for(Car car : cars) {
        car.start();
    }
}