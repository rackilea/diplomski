setGreenColor();
Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
   setRedColor();
  }
}, 1000);