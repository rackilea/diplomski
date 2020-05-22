public class Main extends Activity 
    {
    private MyCountDownTimer myCountDownTimer;

    @Override
    public void onCreate(Bundle savedInstanceState){
        myCountDownTimer = new MyCountDownTimer(5000, 1000);
        myCountDownTimer.start();
    }

    public void finished(){
        Log.e("Testing", "OK na");
    }

    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() { 
            finished();
        }

        @Override
        public void onTick(long millisUntilFinished) {
           Log.e("TESTINg","" + millisUntilFinished/1000);
        }
    }
}