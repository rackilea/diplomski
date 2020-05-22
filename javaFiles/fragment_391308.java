public class CarDatabase {

  Car[] carList = new Car[100];
  int carsStored;

  // No need for a constructor since we don't need any initialization.
  // The default constructor will do it's job.

  public void createAccount(String name, String color) {
    carList[carsStored++] = new Car(name, color);
  }
}