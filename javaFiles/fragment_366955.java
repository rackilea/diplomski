interface Factory< T > {
    T make();
}

public class CarFactory implements Factory< Car > {
    Car make() { ... }
}

public class PlaneFactory implements Factory< Plane > {
    Plane make() { ... }
}

public class UniversalVehicleFactory {
    public < T extends Vehicle > T make( Factory< T > factory ) {
        return factory.make();
    }
}