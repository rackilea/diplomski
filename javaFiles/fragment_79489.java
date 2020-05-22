ExecutorService executor = Executors.newSingleThreadExecutor(); // An application wide thread pool executor is better.

Callable<InputStream> task = new Callable<InputStream>() {
    @Override
    public InputStream call() throws Exception {
        // Do here your webservice call job.
        return new URL("http://stackoverflow.com").openStream();
    }
};

try {
    InputStream input = executor.invokeAny(Arrays.asList(task), 60, TimeUnit.SECONDS);
    // Successful! Forward to success page here.
} catch (TimeoutException e) {
    // Timeout occurred. Forward to timeout page here.
}