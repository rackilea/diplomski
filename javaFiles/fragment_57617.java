public void doSave(final StatusWindow s) {
    if (saveThis) {
        Thread t = new Thread( new Runnable() {
            public void run() {
               saveThis(s);
            }
        });
        t.start();
    }
    //...
}