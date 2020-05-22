private static void pause(int millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        // Do nothing
    }
}