public void dispose() {
    isStarted = false;
    interrupt();
    try {
        join();
    } catch(InterruptedException exc) {
        exc.printStackTrace();
    }
}