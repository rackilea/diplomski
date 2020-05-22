try {
    // to sleep 10 seconds
    Thread.sleep(10000);
} catch (InterruptedException e) {
    // recommended because catching InterruptedException clears interrupt flag
    Thread.currentThread().interrupt();
    // you probably want to quit if the thread is interrupted
    return;
}