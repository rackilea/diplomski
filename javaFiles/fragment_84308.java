Timer t = new Timer();
t.schedule(new TimerTask() {
  @Override
  public void run() {
    System.exit(0);
  }
}, 30*60000);