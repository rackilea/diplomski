//THE LOGIC BEFORE YOU WANT TO WAIT THE EXECUTOR
...
executor.shutdown();
try {
    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
} catch (InterruptedException e) {
    e.printStackTrace();
}
//THE LOGIC AFTER THE EXECUTOR TERMINATION
...