public class Server {
    CompletableFuture<Void> myFuture;
    ...

    public void starterMeth() {
        myFuture = new CompletableFuture<Void>(); // Create future
        myFuture.runAsync(new ServerRunnable()); // Start execution in parallel
    }

    public void stopMeth() {
        myFuture.cancel(true); // Stop the future
    }

    ...
}