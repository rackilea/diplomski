public final class ThreadSafeHolder {
    private final SomeMutableData data = new SomeMutableData();

    public ThreadSafeHolder(SomeMutableData data) {
        copyFrom(data);
    }

    public synchronized void copyTo(SomeMutableData data) {
        data.copyFrom(this.data);
    }

    public synchronized void copyFrom(SomeMutableData data) {
        this.data.copyFrom(data);
    }
}