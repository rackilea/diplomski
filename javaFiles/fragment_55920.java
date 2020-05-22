interface UserInterface extends Runnable {
    void someOtherFunction();
    // void run() is inherited as part of the interface specification
}

public class SpecificInterface implements UserInterface {
    @Override
    public void someOtherFunction() {
        . . .
    }

    @Override
    public void run() {
        . . .
    }
}