public class MainActivity extends Activity implements OnClickListener {

private Button startB;
public TextView text;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
startB = (Button) this.findViewById(R.id.button1);
startB.setOnClickListener((OnClickListener) this);
text = (TextView) findViewById(R.id.textView1);
}

@Override
public void onClick(View v) {
    new CountDownTimer(30000, 1000) { // adjust the milli seconds here

        public void onTick(long millisUntilFinished) {
        text.setText(""+String.format("%d min, %d sec", 
                        TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
        }

        public void onFinish() {
           text.setText("done!");
        }
     }.start();

}   
}