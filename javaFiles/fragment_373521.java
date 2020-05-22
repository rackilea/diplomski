final Runnable runnable = new Runnable() {
  final Object lock = new Object();

  final ImportantInfo info = new ImportantInfo();

  @Override
  public void run() {
    while (true) {
      doABunchOfStuff();
      synchronized (lock) {
          info.load();
      }
      doABunchOfOtherStuff();
    }
  }
};