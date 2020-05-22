public MyTimer {
    private long startTime;
    private long elapsed;
    private boolean running;

    public void start() {
        startTime = System.currentTimemillis();
        running = true;
    }

    public void stop() {
        elapsed = elapsed + System.currentTimemillis() - startTime; 
        running = false;   
    }

    public long getElapsed() {
        if (running) {
            return elapsed + System.currentTimemillis() - startTime;
        } else {
            return elapsed;
        }
    }
}