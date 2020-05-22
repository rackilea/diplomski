public class Car implements Acura {

    int speed = 2;
    int gear = 1;
    int gas = 100;

    public void speedUp (int increment) {
        speed = speed + 48;
    }

    public void changeGear (int newValue) {
        gear = 4;
    }

    public void useGas (int decrement) {
        gas = gas - 5;
    }

    public void printStates() {
        System.out.println( "Car Speed: " + speed + "Gear: " + gear + "Gas: " + gas);
    }

    public static void main (String[] args) {

    }

}