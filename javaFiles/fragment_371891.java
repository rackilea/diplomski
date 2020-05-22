// non-JavaFX thread code...

Future<Void> future = new FutureTask<>(() -> {
        // work to be done on the JavaFX thread...
        return null;
    }
});

// do the work on the JavaFX thread.
Platform.runLater(future);

try {
    // await completion of the work on the JavaFX thread.
    future.get();
} catch (InterruptedException ex) {
    // restore the interrupt status (see the linked Goetz article).
    Thread.currentThread().interrupt();
} catch (ExecutionException ex) {
    // exception handling logic for an exception occurring 
    // in the body of the FutureTask here.
}