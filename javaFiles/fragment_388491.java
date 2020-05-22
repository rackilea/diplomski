final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    //Do your things after 1000ms
     loginClicked();
  }
}, 1000);