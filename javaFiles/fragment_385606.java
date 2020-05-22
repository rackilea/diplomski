import java.util.*;

public abstract class Player {
    String nm; // instance fields cant be declared as abstract
    public abstract void displayDetails();
}

class Booking extends Player {
    { // instance initialization block
      nm = "Sam";
    }

    void displayDetails() {
        System.out.println("Name is:" + name);
    }
}