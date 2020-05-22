private CountDownTimer timer;
private TextView txtProgress;
private Button stopButton;
...

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtProgress = findViewById(R.id.tv);

    timer = new CountDownTimer(30000, 500) {

        public void onTick(long millisUntilFinished) {
                    handler.post(() -> {
                        txtProgress.setText("any text");
                    });
        }

        public void onFinish() { }

    }.start();

    findViewById(R.id.stopButton).setOnClickListener(v -> timer.cancel());
}