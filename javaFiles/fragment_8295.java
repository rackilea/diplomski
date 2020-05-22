public static void main(String[] args) {
    // make a Car.
    Car myCar = new Car();
    myCar.printCarStatus();

    // turn the car on
    myCar.setState(1);
    myCar.printCarStatus();

    // speed up
    myCar.accelerate(20);
    myCar.printCarStatus();

    // brake
    myCar.stop();
    myCar.printCarStatus();

    // speed up, put the pedal to the metal
    myCar.accelerate(1000); // car tops out at 200
    myCar.printCarStatus();

    // lost control of my car, crash
    myCar.crash();
    myCar.printCarStatus();
}

public void printCarStatus() {
    System.out.println("State: " + this.state);
    System.out.println("Fuel: " + this.fuel);
    System.out.println("Speed: " + this.speed);
    System.out.println(); // prints an empty line so we don't get entries mixed up.
}