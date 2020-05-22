class SomeClass {

    final private Object lock = new Object();

    void method() {
        ...
        synchronized (lock) {
            ...
        }
        ...
    }
}