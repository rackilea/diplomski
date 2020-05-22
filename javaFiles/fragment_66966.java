ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> future = executor.submit(new Callable() {

    public String call() throws Exception {
        //do operations you want
        return "OK";
    }
});
try {
    System.out.println(future.get(2, TimeUnit.SECONDS)); //timeout is in 2 seconds
} catch (TimeoutException e) {
    System.err.println("Timeout");
}
executor.shutdownNow();