public static void main(String[] args) throws Exception {

    doTest(3);

}

private static void doTest(final int times) {

    ScheduledExecutorService tp = Executors.newScheduledThreadPool(times);

    for (int i = 0; i < times; ++i) {
        tp.schedule(new MyRunnable(), 1, TimeUnit.SECONDS);
    }



    System.out.println("Calling shutdown");
    tp.shutdown();
}


static class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello world");

    }

}