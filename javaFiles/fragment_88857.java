Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    Intent intent = new Intent(CURRRENTACTIVITY.this, YOURSECONDACTIVITY.class);
    startActivity(intent);
    finish();
  }
}, 3000);