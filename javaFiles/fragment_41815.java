class Deadlock {

    static boolean staticInitFinished = false;
    // unique value for each thread!
    static ThreadLocal<Boolean> currentThreadRunsStaticInit = ThreadLocal.withInitial(() -> Boolean.FALSE);


    static CompletableFuture<Integer> cf;
    static int foo;

    static void enforceStaticInit() {
        synchronized (Deadlock.class) {
            // is init finished?
            if (staticInitFinished)
                return;
            // are we the thread already running the init?
            if(currentThreadRunsStaticInit.get())
                return;
            currentThreadRunsStaticInit.set(true);

            cf = new CompletableFuture<Integer>();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    calcF();
                }
            }).start();
            try {
                foo = cf.get();
                System.out.println("Future result = " + cf.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            currentThreadRunsStaticInit.set(false);
            staticInitFinished = true;
        }
    }

    private static void calcF() {
        enforceStaticInit();
        cf.complete(42);
    }

    public static void printFoo() {
        enforceStaticInit();
        System.out.println("Print foo " + foo);
    }
}