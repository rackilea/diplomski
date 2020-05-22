class Executor {
    public static void execAndLogOnTimeout(Runnable runnable, long timeout) {
        // Save start time
        runnable.run();
        // Save end time
        // If time taken > timeout: log
    }
}

Executor.execAndLogOnTimeout(new Runnable() {
    @Override public void run() {
        // The code to be clocked
    }
}, Config.timeoutForThisPieceOfCode());