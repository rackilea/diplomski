final int y = new Runnable() {
    int x;
    {
        x = 5;
        doRun(this);
    }
    public void run() {
        ... blah ...
    }
}.x;