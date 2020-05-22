public void raceStart() {
    long startTime = System.currentTimeMillis();
    long finishTime;
    CarModel winner = null;
    while (true) {
        if (winner != null) {   // Race has finished
            processResults(winner, finishTime - startTime);
            return;
        }
        for (CarModel car : theCar) {
            int carDistance = car.getCarDistance();
            carDistance += randomWithRange(0, 50);
            car.setCarDistance(carDistance);
            if (carDistance >= maxDistance) {                 
                if (winner == null || carDistance > winner.getCarDistance()) {
                    winner = car;   // We have new winner
                    finishTime = System.currentTimeMillis();
                }
            }
        }
    }
}

private void processResults(CarModel winner, long winnerTime) {
    System.out.println("First winner is :" + winner.getDriverNames() + "\nTOTAL DISTANCE TRAVELED : "
            + winner.getCarDistance() + " METERS " + "\nTOTAL TIME TO FINISH THE RACE : " + winnerTime);

    System.out.println("\n\nALL OTHERS COMPETITORS RACE DETAILS");
    for (CarModel car : theCar) {
        if (!car.equals(winner)) {// need to skip winner
            System.out.println(
                    "DRIVER NAME :" + car.getDriverNames() + "\nCAR DISTANCE : " + car.getDistance() + "\n");
            System.out.println();
        }
    }
}