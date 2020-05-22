executor.shutdown();
while(!executor.isTerminated()) {
    try {
        executor.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}