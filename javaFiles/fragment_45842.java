Class A {

    B b;
    private volatile boolean called;

    public synchronized void doSth { 
         if (called) return;
         called = true;
         b.modify();
    }
}