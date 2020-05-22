class SyncCounter {

    private final AtomicInteger x;

    public SyncCounter() {
     this(0);   
    }

    public SyncCounter(int x) {
       this.x = new AtomicInteger(x);
    }

    int getX() {
        return x.get(); 
    }

    void setX(int x) {
        this.x.set(x);
    }

    int increment() {
        return x.incrementAndGet();
    }


    int decrement() {
        return x.decrementAndGet();
    }

}