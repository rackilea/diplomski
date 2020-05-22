synchronized void start() {

    if (running) {
        return;
    }
    running = true;

    Thread t = new Thread(this);
    t.start();

}