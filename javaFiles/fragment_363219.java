public static Car createCar(String make, String model, int hp, double acceleration ) {
  Car car = new Car(make, model);
  car.setHp(hp);
  car.setAcceleration(acceleration);
  return car;
}