for (Car car : cars {
    Stats s = stats.get(car.maker);
    if (s == null) {
        s = new Stats();
        stats.put(car.maker, s);
    }
    stats.count++;
    stats.totalWeight+=car.weight;
}

for (Car car in importantCars) {
    stats.get(car.maker);
}