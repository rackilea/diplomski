interface Vehicle{
    void drive();
}

class Car implements Vehicle {
    private int numberOfDoors;

    public Car(int numberOfDoors) {
         this.numberOfDoors = numberOfDoors;
     }

    public void drive() {
        System.out.println(numberOfDoors);
    }
}


class TruckWithTrailer implements Vehicle {
    private int numberOfDoors;
    private int numberOfTrailers;

    public TruckWithTrailer(int numberOfDoors,numberOfTrailers) {
          this.numberOfDoors = numberOfDoors;
          this.numberOfTrailers = numberOfTrailers;
    }

    @Override
    public void drive() {
        System.out.println(numberOfDoors + numberOfTrailers);
    }
}