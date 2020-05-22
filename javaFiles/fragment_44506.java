Handler mHandler = new Handler();
int mDelay = INITIAL_DELAY;

// try request
mHandler.postDelayed(mDelay, new Runnable() {
   public void run() {
      // try your request here; if it fails, then repost:
      if (failed) {
          mDelay *= 2;  // or as per your formula
          mHandler.postDelayed(mDelay, this);
      }
      else {
          // success!
      }
   }
});