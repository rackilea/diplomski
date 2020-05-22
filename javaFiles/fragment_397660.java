class Sync {

    private Writer w1, w2;
    private Object whatEver;

    public Sync() {
        w1 = new Writer();
        w2 = new Writer();
        whatEver = new Object();
    }

    public void go() {
        synchronized (whatEver) {
            w1.log(Thread.currentThread().getName() + "...1");
            //!All threads must performance parallel, but they do it consistently.
            w2.log(Thread.currentThread().getName() + "...2");
            //All threads must performance parallel, and they do it.
        }
    }
}