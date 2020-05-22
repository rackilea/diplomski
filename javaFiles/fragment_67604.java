final Object mon = ...;
Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() {
        synchronized (mon) {
            try {
                mon.wait(); //blocks the t1 thread
            } catch (InterruptedException e) {
                //
            }
        }
    }
});