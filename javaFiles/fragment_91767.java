static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

public static void async(final int a) {
    singleThreadExecutor.submit(new Runnable() {
        @Override
        public void run() {
            meth(a);
        }
    });
}