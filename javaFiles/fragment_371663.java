interface TimeSource {
    long currentTimeMS(); // actually I have currentTimeNS
    void currentTimeMS(long currentTimeMS);
}

enum VanillaTimeSource implements TimeSource {
    INSTANCE;

    @Override
    public long currentTimeMS() {
        return System.currentTimeMillis();
    }

    @Override
    public void currentTimeMS(long currentTimeMS) {
        // ignored
    }
}

class FixedTimeSource implements TimeSource {
    private long currentTimeMS;
    @Override
    public long currentTimeMS() {
        return currentTimeMS;
    }

    @Override
    public void currentTimeMS(long currentTimeMS) {
        this.currentTimeMS =              currentTimeMS;
    }
}