public abstract class FactoryMethod {
    abstract Car rentCar();

    public void driveCar() {
        Car car = rentCar();
        car.drive();
    }

    public static class AudiFactoryMethod extends FactoryMethod {
        @Override
        Car rentCar() {
            return new Audi("red", 5);
        }
    }

    public static class BmwFactoryMethod extends FactoryMethod {
        @Override
        Car rentCar() {
            return new BMW("black", true);
        }
    }

    public static void main(String... args) {
        new AudiFactoryMethod().driveCar();
        new BmwFactoryMethod().driveCar();
    }
}