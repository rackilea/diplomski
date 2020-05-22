class MyCountDownTimer {
    private long millisInFuture;
    private long countDownInterval;
    public MyCountDownTimer(long pMillisInFuture, long pCountDownInterval) {
            this.millisInFuture = pMillisInFuture;
            this.countDownInterval = pCountDownInterval;
        }
    public void Start() 
    {
        final Handler handler = new Handler();
        Log.v("status", "starting");
        final Runnable counter = new Runnable(){

            public void run(){
                if(millisInFuture <= 0) {
                    Log.v("status", "done");
                } else {
                    long sec = millisInFuture/1000;
                    Log.v("status", Long.toString(sec) + " seconds remain");
                    millisInFuture -= countDownInterval;
                    handler.postDelayed(this, countDownInterval);
                }
            }
        };

        handler.postDelayed(counter, countDownInterval);
    }
}