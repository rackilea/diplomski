Runnable UpdateRunnable = new Runnable() {

    @Override
    public void run() {
        updateSec();
    }
};

    public void updateSec() {
          mSeconds++;
          mHandler.postDelayed(UpdateRunnable, 1000);
     }