LongProperty timeMillis = new SimpleLongProperty(0);

AnimationTimer stopwatch = new AnimationTimer() {

    private static final long STOPPED = -1 ;
    private long startTime = STOPPED ;

    @Override
    public void handle(long timestamp) {
        if (startTime == STOPPED) {
            startTime = timestamp ;
        }
        long elapsedNanos = timestamp - startTime ;
        long elapsedMillis = elapsedNanos / 1_000_000 ;
        timeMillis.set(elapsedMillis);
    }

    @Override
    public void stop() {
        startTime = STOPPED ;
        super.stop();
    }
};