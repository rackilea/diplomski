class {
    Object lock1;
    Object lock2;
    void method1() {
        synchronized (lock1) {
            ...
        }
    }
    void method2() {
        synchronized (lock2) {
            ...
        }
    }
}