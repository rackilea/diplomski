public void run() {
    boolean running = true;
    while(running) {
        running = doWork();
        if (Thread.interrupted()) {
            return;
        }
    }
}