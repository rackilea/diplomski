public static void main(String[] args) {
    Clock myClock = new Clock;   // new clock object.

    while (true) {
        myClock.tick();
        // wait for a second.
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie) {
            // Handle the exception
        }
    }
}