public static void main(String[] args) {
    // let's say you have another OlderCar implmentation
    // that has a KeyStartEngine
    OlderCar car = new OlderCar();
    car.getEngine().startEngine();

    // I just hit the lotto, lets upgrade!
    PushStartEngine engine = store.buyPushStartEngine();
    car.setEngine(engine);
    car.getEngine().startEngine();
}