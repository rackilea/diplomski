private final static ReentrantLock initLock = new ReentrantLock();

private static void redoHeavyInitialisation() {
    if (needToReinitialise()) {
        MyClass.initLock.lock();
        try {
            if (needToReinitialise()) {
                doHeavyInitialisation();
            }
        } finally {
          MyClass.initLock.unlock();
        }
    }
}