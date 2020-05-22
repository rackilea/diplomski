public enum Throwables {
    ;

    private static final InheritableThreadLocal<Throwable> STARTING_THREAD = new InheritableThreadLocal<>();

    public static void set(Throwable t) {
        STARTING_THREAD.set(t);
    }

    public static Throwable get() {
        return STARTING_THREAD.get();
    }

    public static void printStartingThrowable() {
        Throwable throwable = get();
        if (throwable == null) return;
        throwable.printStackTrace();
    }

    public static Thread start(Runnable run, String name, boolean daemon) {
        Throwable tmp = new Throwable("Started here");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                set(tmp);
                run.run();
            }
        }, name);
        t.setDaemon(daemon);
        t.start();
        return t;
    }

    public static void main(String... ignored) {
        try {
            method();
        } catch (Throwable t) {
            System.err.println("\nThrown in " + Thread.currentThread());
            t.printStackTrace();
            printStartingThrowable();
        }

        start(new Runnable() {
            @Override
            public void run() {
                try {
                    method();
                } catch (Throwable t) {
                    System.err.println("\nThrown in " + Thread.currentThread());
                    t.printStackTrace();
                    printStartingThrowable();
                }
            }
        }, "Test thread", false);

    }

    private static void method() {
        throw new UnsupportedOperationException();
    }
}