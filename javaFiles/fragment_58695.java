for (Car car : myCars) {
    String name = ... // get the details of the car from an external source
    String type = ... // get the details of the car from an external source
    car.setName(name); // of course you'll have to implement setName() and setType()
    car.setType(type); // which is a better practice than exposing the class members via public access
}