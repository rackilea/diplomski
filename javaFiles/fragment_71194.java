Runnable txtClearRun = new Runnable(){
  public void run() {
    blankbutton();
  }
};
handler.postDelayed(txtClearRun, 10* 1000);
.
.
.
handler.removeCallbacks(txtClearRun);