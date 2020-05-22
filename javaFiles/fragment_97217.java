public void waitForResponse() {
    boolean result = latch.await(10, TimeUnit.SECONDS);
    // check result and react correspondingly
}

public void notifyOKCommandReceived() {
    latch.countDown();
}