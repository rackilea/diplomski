public static void main(String[] args) throws Exception {
    final long start = System.currentTimeMillis();
    Timer timer = new Timer();

    // Schedule a new task that runs at a 10ms interval and stars immediately
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("10ms delayed task ran at " + (System.currentTimeMillis() - start));
        }
    }, 0, 10);

    // Schedule a task to start in 50ms that takes 40ms to run.
    // It cancels itself so it's only run once.
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("slow task ran at " + (System.currentTimeMillis() - start));
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {

            }
            this.cancel();
        }
    }, 50, 10);

    // Wait 100 ms for the demo to end, then stop the timer.
    Thread.sleep(100);
    timer.cancel();
}