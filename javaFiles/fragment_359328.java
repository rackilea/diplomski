public void run() {
    while(!Thread.currentThread().isInterrupted()) {
        doYourStuff();
    }
    cleanup();
}