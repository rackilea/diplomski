class Door{
    public void open() {
        System.out.println("Door is opened");
    }
    public void close() {
        System.out.println("Door is closed");
    }
}

class Pushbutton extends Door{
    public void status(boolean button) {
        if (button==true) {
            super.open();
        }
        else {
            super.close();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        boolean open=true;

        // create object of type Pushbutton
        Pushbutton button = new Pushbutton();

        // call the method status from the object
        // and pass it the boolean parameter
        button.status(open); //line 25
    }
}