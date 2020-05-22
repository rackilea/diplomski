public static void main(String[] args) {
    CarManager carManager = new CarManager();

    // here you'd call methods on carManager
    // for instance if CarManager had an addCar(...) method

    Car car = new Car(4);
    carManager.addCar(car);
}