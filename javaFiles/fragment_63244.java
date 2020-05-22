public class CounterActivity extends Activity {
    /** Called when the activity is first created. */
    TextView timeText;
    Button startBut;
    Button stopBut;
    MyCountDownTimer mycounter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        timeText = (TextView) findViewById(R.id.time);
        startBut = (Button) findViewById(R.id.start);
        stopBut = (Button) findViewById(R.id.stop);
        mycounter = new MyCountDownTimer(20000, 1000);
        RefreshTimer();
    }

    public void StartTimer(View v) {
        Log.v("startbutton", "saymaya basladi");
        mycounter.Start();
    }

    public void StopTimer(View v) {
        Log.v("stopbutton", "durdu");
        mycounter.Stop();
    }

    public void RefreshTimer() 
    {
        final Handler handler = new Handler();
        final Runnable counter = new Runnable(){

            public void run(){
                timeText.setText(Long.toString(mycounter.getCurrentTime()));
                handler.postDelayed(this, 100);
            }
        };

        handler.postDelayed(counter, 100);
    }
}