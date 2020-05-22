class Looper extends TimerTask {
  // ** Add this **
  volatile boolean running = false;

  public Looper() {
  }

  @Override
  public void run() {
    // ** Add this **
    if (!running) {
      running = true;
      try {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
          }

        });
        // ** Add this **
      } finally {
        running = false;
      }

    }
  }

}