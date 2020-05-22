private final Semaphore runMutex = new Semaphore(1);

public void run(ProcessBuilder processBuilder) throws IOException, InterruptedException {
    runMutex.acquire();
    setActive();
    ExternalCommandRunner self = this;
    Thread taskThread = new Thread(new Task<Void>() {
        @Override
        public Void call() throws Exception {
            runningProcess = processBuilder.start();

            StreamPrinter  inputStream = new StreamPrinter(runningProcess.getInputStream(), self::handleLog);
            StreamPrinter  errorStream = new StreamPrinter(runningProcess.getErrorStream(), self::handleLog);
            outputTextArea.clear();

            new Thread(inputStream).start();
            new Thread(errorStream).start();
            runningProcess.waitFor();
            return null;
        }

        @Override protected void cancelled() { super.cancelled(); terminate(); }
        @Override protected void failed   () { super.failed   (); terminate(); }
        @Override protected void succeeded() { super.succeeded(); terminate(); }

        private void terminate() {
            stop.fire();
            setInactive();
            runMutex.release();
        }
    });
    taskThread.setDaemon(true);
    taskThread.start();
}