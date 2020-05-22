ExecutorService es = Executors.newSingleThreadExecutor();
Future<Object> f = es.submit(() -> { throw new OutOfMemoryError(); });
try {
    f.get();
}
catch(ExecutionException ex) {
    System.out.println("caught and wrapped: "+ex.getCause());
}
finally { es.shutdown(); }