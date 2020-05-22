ScheduledExecutorService s=Executors.newScheduledThreadPool(1);
s.scheduleWithFixedDelay(new Runnable() {
  public void run() {
    try {
      MyClass myClass = new MyClass();
      myClass.startInfiniteLoop();
    } catch(SomeException ex) {}
  }
}, 0, MyClass.DEFAULT_SLEEP_TIME, TimeUnit.MILLISECONDS);