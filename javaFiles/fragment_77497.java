class MyObject { /* ... */ }

interface MyObjectProvider {
    MyObject getMyObject();
}

class Creator implements MyObjectProvider {
    private MyObject obj;
        /* ... */
    @Override
    public MyObject getMyObject() {
        return obj;
    }

    /** Invoked at some point in time. */
    void createMyObject() {
        obj = new MyObject();
    }
}

class Consumer {
    private MyObjectProvider provider;

    Consumer(MyObjectProvider mop) {
        provider = mop;
    }

    void consume() {
        // At some point in time...
        MyObject o = provider.getMyObject();
    }
}