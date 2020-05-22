class LoggingJob implements Runnable {
    private Exception ex;

    public LoggingJob(Exception ex) {
        this.ex = ex;
    }

    public void run() {
        // write ex to log file
    }
}