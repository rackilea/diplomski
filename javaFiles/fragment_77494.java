ArrayList<Car> cars = ...//Filled with cars
Comparator<Car> carSorter = new Comparator<Car>() {
  @Override
  public int compare(Car a, Car b) {
    return a.getID() - b.getID();
  }
};
Collections.sort(cars, carSorter);//After this line, cars will be in order