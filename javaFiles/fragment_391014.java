public Result call() {
    try {
       ...
       if (!Thread.currentThread.isInterrupted()) {
          // Save to the database
          return result;
       } else {
          return // some result that means interrupted.
       }
    catch (Exception ex) {
       return // some result that means failed.
    }
}