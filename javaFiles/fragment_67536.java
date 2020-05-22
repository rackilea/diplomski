Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  public void run() {
    animation.start();
  }
  }, timeNeeded);