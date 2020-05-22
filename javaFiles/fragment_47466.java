class Foo implements Runnable {
  @Override
  public void run() {
    try {
    } catch (Exception e) {
      // either handle it properly if you can, or ...
      throw new RuntimeException(e);
    }
  }
}