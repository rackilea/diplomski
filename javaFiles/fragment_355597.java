public static void waitUntil(long timestamp) {
    long millis = timestamp - System.currentTimeMillis();
    // return immediately if time is already in the past
    if (millis <= 0)
        return;
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        throw new RuntimeException(e.getMessage(), e);
    }
}