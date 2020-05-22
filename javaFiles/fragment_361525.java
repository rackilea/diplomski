public class CountDownActivity extends AppCompatActivity {
TextView textView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_count_down);

    //initialize the ui component
    textView = (TextView) findViewById(R.id.timeText);

    //get the text from intent
    String timerText = getIntent().getStringExtra("time");
    Toast.makeText(CountDownActivity.this, timerText, Toast.LENGTH_SHORT).show();

    //convert the string into integer
    int time = Integer.valueOf(timerText);

    //Initialize a CountDownTimer class with the time data from previous activity
    //which will set the text view with countDown time

    new CountDownTimer(time * 1000, 1000) {
        public void onTick(long millisUntilFinished) {
            //set the remaining time in the textView
            textView.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            textView.setText("done!");
        }
    }.start();
}