ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
final Future<Boolean> handler = executor.submit(new Callable<Boolean>() {
    @Override
    public Boolean call() throws Exception {
        return processTransfer();
    }
});
success = handler.get(10, TimeUnit.MINUTES);