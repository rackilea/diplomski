public Car getCar(String CarMake) {
    for (int i = 0; i < cars.size(); i++) {
        //if (cars.get(i).getMake() == CarMake) {
        if (cars.get(i).getMake().equals(CarMake)) {
            return cars.get(i);
        }
    }
    return null;
}