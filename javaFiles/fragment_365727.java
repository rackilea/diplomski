FutureTask<Object> f = new FutureTask<>(() -> { throw new OutOfMemoryError(); });
f.run(); // see, it has been caught
try {
    f.get();
}
catch(ExecutionException ex) {
    System.out.println("caught and wrapped: "+ex.getCause());
}