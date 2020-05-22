public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    for (int i = 0; i < 10; i++) {
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        executorService.execute(myRunnable);
    }

    executorService.shutdown();
}