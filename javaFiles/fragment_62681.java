Runtime.getRuntime().addShutdownHook(
  new Thread("app-shutdown-hook") {
    @Override 
    public void run() { 
      System.out.println("bye"); 
    }
});