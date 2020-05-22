public class CarFactory {
    Car giveMeACar() { ... };
}

public class SpecialCarFactory extends CarFactory {
    @Override
    Object giveMeACar() {
        return "hello world";
    }
)

public class Driver {
    void drive() {
        CarFactory carFactory = new SpecialCarFactory();

        Car car = carFactory.giveMeACar();
        // err, wait, sorry, can't do that. 
        // This car factory, despite its name, doesn't produce cars. 
        // It produces objects, and I've heard they're just 
        // "hello world" strings. Good luck driving a "hello world"
        // string on a highway!
    }
}