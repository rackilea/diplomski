public static void main(String[] args) throws Exception {

    doTest(3);

}

private static void doTest(final int times) {

    ScheduledExecutorService tp = Executors.newScheduledThreadPool(times);

    Thread[] runnables = new Thread[times];
    for (int i = 0; i < runnables.length; ++i) {
        runnables[i] = new Thread(new MyRunnable());
    }

    // schedule for them all to run
    int i = 1;
    for (Thread t : runnables) {
        tp.schedule(t, i++, TimeUnit.SECONDS);
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