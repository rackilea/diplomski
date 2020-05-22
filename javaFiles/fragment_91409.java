actorSystem.registerOnTermination(new Runnable {
  @Override 
  public void run() {
    System.out.println("Shutting down!");
  }
});

// ...

try {
  // ...
} catch (NoSuchElementException ex) {
  getContext().getSystem().terminate();
}