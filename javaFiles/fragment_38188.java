public void run() {
    while(!isInterrupted()) {
        try {
            ...
            sleep(1000L);
        } catch (InterruptedException ex) {
            break;
        }
    }
}