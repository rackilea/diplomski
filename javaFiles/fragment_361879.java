public interface VehicleVisitor {
    public void visit(Car car);
    public void visit(Truck truck);
}

public class Car extends Vehicle {

    @Override
    public void insert(VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }
}

public class Truck extends Vehicle {
    @Override
    public void insert(VehicleVisitor vehicleVisitor) {
        vehicleVisitor.visit(this);
    }
}

public abstract class Vehicle {
    public abstract void insert(VehicleVisitor vehicleVisitor);
}

public class VehicleVisitorImpl implements VehicleVisitor {

    @Override
    public void visit(Car car) {
        System.out.println("insert car");
    }

    @Override
    public void visit(Truck truck) {
        System.out.println("insert truck");
    }
}

public class Main {

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        // finally the agnostic call
        vehicle.insert(new VehicleVisitorImpl());
    }

}