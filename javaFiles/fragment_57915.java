while (!Thread.currentThread().isInterrupted()) {
    try {
        Thread.sleep(1500);

    } catch (InterruptedException e) {
        Thread.currentThread.interrupt();
    }
}