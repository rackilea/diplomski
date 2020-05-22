static final private int DELAY_TIME = 30*1000;

private Runnable runnable = new Runnable() {
   @Override
   public void run() {
      /* do what you need to do */
      YOUR CODE HERE
      /* post new handler to re-trigger in 30 seconds */
      // wrap this in IF statement to make a way of stopping the looping.
      handler.postDelayed(this, DELAY_TIME );
   }
};

// create a handler that points to the UI Thread's Looper
private Handler handler = new Handler(Looper.getMainLooper());
// post the first runnable, that will start a cascading repeat set of runnables
handler.postDelayed(runnable, DELAY_TIME );