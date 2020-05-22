public class Foo {
    private final static Object lock1 = new Object();
    private final static Object lock2 = new Object();

    public static void method1() {
        synchronized(lock1) {
            ...
        }
    }

    public static void method2() {
        synchronized(lock1) {
            ...
        }
    }

    public static void method3() {
        synchronized(lock2) {
            ...
        }
    }
}