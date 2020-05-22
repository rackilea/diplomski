class ExecutorWrapper {

    private ExecutorService ioExec = Executors.newFixedThreadPool(4);
    private ExecutorService genExec = Executors.newFixedThreadPool(12);

    public Future<?> submit(final IOTask task) {
        return ioExec.submit(task);
    }

    public Future<?> submit(final Runnable task) {
        return genExec.submit(task);
    }
}

interface IOTask extends Runnable {}