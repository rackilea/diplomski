public class Car extends Vehicle {

  public void method(Car otherCar, Vehicle otherVehicle) {
    System.out.println(this.numberOfWheels);
    System.out.println(otherCar.numberOfWheels);
    System.out.println(otherVehicle.numberOfWheels); //error here!
  }
}