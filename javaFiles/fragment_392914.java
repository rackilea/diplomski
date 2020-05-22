final AtomicInteger y = new AtomicInteger();
new Runnable() {
    int x;
    {
        x = 5;
        doRun(this);
        y.set(x);
    }
    public void run() {
        ... blah ...
    }
};