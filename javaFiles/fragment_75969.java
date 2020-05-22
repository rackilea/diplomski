class MyRunnable implements Runnable {
    private static AtomicLong idCounter = new AtomicLong(0);
    private long id;

    public MyRunnable() { this.id = idCounter.getAndIncrement(); }

    public void setId(long id) { this.id = id; }
    public long getId() { return this.id; }
    public void run() {}
}