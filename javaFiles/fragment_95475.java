public class CarImpl extends AbstractVehicles implements Car {

    protected AI initAI() {
        return new CarAI();
    }
}

public class BicycleImpl extends AbstractVehicles implements Car {

    protected AI initAI() {
        return new BicycleAI();
    }
}