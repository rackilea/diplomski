public static synchronized void method() {...}

public void someOtherMethod() {
    synchronized(this) {
    }
}