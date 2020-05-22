public class Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            MyUUIDFactory.getUUIDPerThread();
            MyUUIDFactory.getUUIDPerThread();
        }, "My Thread-1");

        Thread t2 = new Thread(() -> {
            MyUUIDFactory.getUUIDPerThread();
            MyUUIDFactory.getUUIDPerThread();
        }, "My Thread-2");

        t1.start();
        t2.start();
    }

}

class MyUUIDFactory {
    private static final ThreadLocal<String> localWebDriver = ThreadLocal.withInitial(
            () -> UUID.randomUUID().toString());

    public static String getUUIDPerThread() {
        return localWebDriver.get();
    }
}