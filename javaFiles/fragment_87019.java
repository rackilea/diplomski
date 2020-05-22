public class MainActivity extends Activity { 
TextView tv;
  public String secsRemain = "not set";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv = (TextView) findViewById(R.id.textView1);
    startBrewTimer(200000);     
}
private void startBrewTimer(long remaningMillis){
    CountDownTimer counter = CountDownTimer(remaningMillis, 1000){
        public void onTick(long millisUntilDone){
        secsRemain = "seconds remaining: " + millisUntilFinished / 1000; 
          tv.setText(secsRemain);                    
        }

        public void onFinish() {
            tv.setText("DONE!");

        }
    }.start();
}
 }