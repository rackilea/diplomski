class Listener implements SmartLifecycle { // default phase is last (after the containers for start, before for stop).

    private volatile boolean running;

    @Override
    public void start() {
        this.running = true;
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    ...

}