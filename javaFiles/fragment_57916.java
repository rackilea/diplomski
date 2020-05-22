try {
    while (!Thread.currentThread().isInterrupted()) {
        Thread.sleep(1500);
    }
} catch (InterruptedException e) {
    Thread.currentThread.interrupt();
}