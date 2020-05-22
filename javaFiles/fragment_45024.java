class AttrWrapper<T extends Serializable> {
    public final T value;
    public final long timeoutMs;
    private long lastAccess = System.currentTimeMillis();

    public AttrWrapper(T value, long timeoutMs) {
        this.value = value;
        this.timeoutMs = timeoutMs;
    }
    public boolean isValid() {
        long now = System.currentTimeMillis();
        if (now - lastAccess > timeoutMs)
            return false;
        lastAccess = now;
        return true;
    }
}