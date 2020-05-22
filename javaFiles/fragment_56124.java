long timeInMilliseconds = 0L;
long timeSwapBuff = 22320000; // 6Hours:12Minutes:00Seconds
long updatedTime = 0L;
private Button startButton;
private Button pauseButton;
private TextView timerValue;
private long startTime = 0L;
private Handler customHandler = new Handler();
private Runnable updateTimerThread = new Runnable() {

    public void run() {
        timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
        updatedTime = timeSwapBuff + timeInMilliseconds;
        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(updatedTime),
                TimeUnit.MILLISECONDS.toMinutes(updatedTime) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(updatedTime)),
                TimeUnit.MILLISECONDS.toSeconds(updatedTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(updatedTime)));
        timerValue.setText(hms);
        customHandler.postDelayed(this, 0);
    }

};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    timerValue = findViewById(R.id.timer);
    startButton = findViewById(R.id.start);
    pauseButton = findViewById(R.id.pause);

    startButton.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {
            startTime = SystemClock.uptimeMillis();
            customHandler.postDelayed(updateTimerThread, 0);

        }
    });

    pauseButton.setOnClickListener(new View.OnClickListener() {

        public void onClick(View view) {

            timeSwapBuff += timeInMilliseconds;
            customHandler.removeCallbacks(updateTimerThread);

        }
    });

}