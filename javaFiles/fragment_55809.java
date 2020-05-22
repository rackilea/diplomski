private void createVehicles() {
    cars = new Car[10];
    for (int i = 0; i < cars.length; i++) {
        cars[i] = new Car();
    }
    motorcycles = new Motorcycle[10];
    trucks = new Truck[10];
    // Init other vehicles as well
}