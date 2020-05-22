public void raceStart() {
    while (true) {
        for (CarModel car: theCar) {
            int carDistance = car.getDistance();   // Get car's current distance
            carDistance += randomWithRange(0, 50);
            car.setDistance(carDistance);          // And set in back
            if (carDistance >= maxDistance) {
                System.out.println(car.getDriverName());
                return;                          // Race has finished
            }
        }
    }
}