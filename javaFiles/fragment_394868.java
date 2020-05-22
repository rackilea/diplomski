ExecutorService runInPlace=new AbstractExecutorService() {
    public void execute(Runnable command) {
        command.run();
    }
    public void shutdown() {}
    public List<Runnable> shutdownNow() { return Collections.emptyList(); }
    public boolean isShutdown() { return false; }
    public boolean isTerminated() { return false; }
    public boolean awaitTermination(long timeout, TimeUnit unit) { return false; }
};
Future<String> f=runInPlace.submit(action);
System.out.println(ft.get());