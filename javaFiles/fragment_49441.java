try {
    wait(); // give up lock and wait
} catch (InterruptedException e) {
    // reset the thread interrupt flag
    Thread.currentThread().interrupt();
    // probably stopping the thread is best
    return;
}