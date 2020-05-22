private Handler handler = new Handler();


private Runnable runnable = new Runnable() {

 public void run() {

        Dt_textView.setText(//getting  the value from a class object);
        As_textView.setText(""getting  the value from a class object);

  /*
   * Now register it for running next time
   */

  handler.postDelayed(this, 1000); // refresh every 1000 ms = 1 sec
 }


};