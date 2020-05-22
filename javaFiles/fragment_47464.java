interface Runnable {
  // guarantees no checked exception is thrown
  public void run();
}

class Foo implements Runnable {
  @Override
  public void run() throws Exception {} // violates the guarantee
}