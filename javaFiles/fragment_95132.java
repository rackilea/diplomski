for (Car car : cars) {
    if (car.diesel) {
        cars.remove(car); // ERROR while looping cars one cannot alter it.
    }
}

for (Iterator<Car> iter = cars.iterator(); iter.hasNext(); ) {
    Car car = iter.next();
    if (car.diesel) {
        iter.remove(); // FINE
    }
}

for (int i = 0; i < cars.size(); ++i) {
    Car car = cars.get(i); // Could be slow for a LinkedList
    if (car.diesel) {
        cars.remove(i); // FINE
        --i; // So we do not skip the next, now at index i.
    }
}