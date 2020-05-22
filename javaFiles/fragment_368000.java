private int currentSpeed;

public static boolean driveable() {

    return true; //or whatever your logic may be
}

public int testSpeed(int speed) {

    if (driveable()) {

        System.out.print(" you are going " + speed + " miles per hour");
        this.currentSpeed = speed;
        return speed;
    }

    else {

        System.out.print("The car is not driveable");
        this.currentSpeed = speed;
        return -1;
    }

}

public void gearChange() {

    if (testSpeed(this.currentSpeed) >= 1 && testSpeed(this.currentSpeed) <= 20) {
        System.out.print("You are in first gear");
    }

}

@Test //run in Junit to see the output
public void testIt() {

    testSpeed(15);
    gearChange();

}