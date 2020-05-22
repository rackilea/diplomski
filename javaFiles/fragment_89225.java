AnimationTimer timer = new AnimationTimer() {

    private long startTime ;

    @Override
    public void start() {
        startTime = System.currentTimeMillis();
        super.start();
    }

    @Override
    public void handle(long timestamp) {
        long now = System.currentTimeMillis();
        time.set((now - startTime) / 1000.0);
    }
};