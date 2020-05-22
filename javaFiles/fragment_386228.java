public synchronized void start() {
    running = true;
    // Not the reference to this...
    thread = new Thread(this, "Display");
    thread.start();

}