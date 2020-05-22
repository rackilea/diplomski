public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    executorService.submit(() -> {
        for (;;)
            statefulRunnable.run();
    });
}

public static final Runnable statefulRunnable = new Runnable() {
    private int state;

    @Override
    public void run() {
        state++;
    }
};