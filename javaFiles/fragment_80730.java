class Example {
    private Object lock = new Object();

    @GuardedBy("lock")
    private Stuff innards = ...;

    public void work() {
        synchronized(lock) {
            workWith(innards.goop());
        }
    }        
}