public class Test {

    public static void main(String[] args) {

        MyCar car = ...;
        car.getEngine().getMileage();
    }
}

interface Car {
    Engine getEngine();
}

interface MyCar extends Car {
    PetrolEngine getEngine();
}

interface Engine {
}

interface PetrolEngine extends Engine {
    String getMileage();
}