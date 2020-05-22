Thread t = new Thread() {
    @Override
    public void run() {
        try {
            System.out.println("Sleeping...");
            Thread.sleep(10000);
            System.out.println("Done sleeping, no interrupt.");
        } catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }
    }
};
t.start();     // Start another thread: t
t.interrupt(); // Main thread interrupts t, so the Thread.sleep() call
               // inside t's run() method will throw an InterruptedException!