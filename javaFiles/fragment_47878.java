Akka.system().scheduler().schedule(
  Duration.create(24, TimeUnit.HOURS),
  new Runnable() {
    public void run() {
      // your code here.
    }
  }
);