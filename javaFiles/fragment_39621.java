public class TestMe{
    public static void main(String[] args) {

        // You just create "a Car" without any more information
        Car car = new Car();
        // Since there was no additional Information you can apply anything to that Car
        car.setT("Anything");
        car.setT(new Integer(5));

        // You create a Car "bound" to the Engine-Interface
        Car<Engine> carGeneral = new Car<Engine>();

        // So only references that are implementing the Engine-Interface can be set to this car
        GasEngine myGasEngine = new GasEngine();
        carGeneral.setT(myGasEngine);

        // While this wont compile:
        // carGeneral.setT("Anything");

        // Also note your car is not an Engine!!!
        System.out.println("A Car is an Engine, true of false? -> "+ (carGeneral instanceof Engine));

    }
}