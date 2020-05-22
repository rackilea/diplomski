Runnable wrappedTask = new Runnable() {
  public void run() {
    try {
      task.run();
    } finally {
      try {
        listener.run();
      } catch (RuntimeException e) 
        // log failure?
      }
    }
  }
};
executor.submit(wrappedTask);