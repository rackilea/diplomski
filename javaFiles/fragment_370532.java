timer.schedule(new looper(m_mainView, this, Rate),new Date());
...
class Looper extends TimerTask {
  final long rate;
  final Looper looper;

  public Looper(long rate) {
    this.rate = rate;
    looper = this;
    // ...
  }

  @Override
  public void run() {
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        // ...
        new Timer().schedule(looper, new Date(new Date().getTime() + rate));
      }

    });

  }

}