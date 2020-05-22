myCar.drive();  //call method of myCar field

Car otherCar = new Car();
otherCar.drive();  //create new car and call its method

new Car().drive()  //call a method on just created object

public Car makeCar() {
  return new Car();
}

Car newCar = makeCar();  //create Car in a different method, return reference to it
newCar.drive();

makeCar().drive();  //similar to your case