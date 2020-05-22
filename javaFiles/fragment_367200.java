public class MapSample {

    private final Object lock = new Object();

    public void doSomething() {
        // Do not access/edit map except for simple read operations

        synchronized(lock) {
            // access/edit map…
        }

        // Do not access/edit map except for simple read operations
    }
}