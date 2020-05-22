public class RequestActivity extends AppCompatActivity {
    private ProgressBar progress_bar;
    private TextView    progress_count;
    private int         REQUEST_TIMER  = 0;
    private Timer       timer          = new Timer(); 
    private Handler     handler        = new Handler();
    private int         counter        = 0; 
    private timerTask   task           = new timerTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_request);
        progress_bar   = (ProgressBar) findViewById(R.id.progress_bar);
        progress_count = (TextView)    findViewById(R.id.progress_count);
        REQUEST_TIMER  = getIntent().getIntExtra("timeout", 0);
        progress_bar.setMax(REQUEST_TIMER);
        timer.scheduleAtFixedRate(task, 500, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        task.cancel();
    }

    private class timerTask extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    counter++;
                    progress_count.setText(
                        String.format(Locale.getDefault(), "%d", counter));
                    progress_bar.setProgress(counter);
                    if (counter >= REQUEST_TIMER) {
                        TravelRequestActivity.this.finish();
                        Toast.makeText(
                            getApplicationContext(), "STOP", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}