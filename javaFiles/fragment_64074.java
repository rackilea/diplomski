// Schedule this to run periodically via ScheduledExecutorService
class ManualStarter {
    private final AtomicBoolen isRunning = new AtomicBoolean(false);
    private ExecutorService exec = Executors.newSingleThreadedExecutor();

    public void run() {
        if (!isRunning.getAndSet(true)) {
            // It wasn't running so this will start it
            exec.submit(new MainProcess(isRunning));
        }
    }
}


class MainProcess extends Runnable {
   private final AtomicBoolean isRunning;

   MainProcess(AtomicBoolean isRunning) { this.isRunning = isRunning; }

   @Override
   public void run() {
       // do whatever it does
       isRunning.set(false);
   }
}