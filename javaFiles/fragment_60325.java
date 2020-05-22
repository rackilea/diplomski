public class MB5Returner extends Thread {

    // ...
    private AtomicBoolean keepRunning;

    MB5Returner(AtomicBoolean keepRunning) {
        this.keepRunning = keepRunning;
    }