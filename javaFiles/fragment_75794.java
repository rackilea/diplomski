try {
     result = future.get();
 } catch (ExecutionException e) {
     if (e.getCause() instanceof InterruptedException) {
        // call() method was interrupted
     }
 } catch (InterruptedException e) {
     // get was interrupted
 }