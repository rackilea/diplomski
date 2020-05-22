Future<?> fa = executor.submit(a);
try {
    fa.get();  // wait on the future
} catch(ExecutionException e) {
    System.out.println("Something went wrong: " + e.getCause());
    // do something specific
}