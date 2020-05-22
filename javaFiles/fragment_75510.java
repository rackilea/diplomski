public class MainActivity extends AppCompatActivity {

Handler handler;
Button buttonStart, buttonStop;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    handler = new Handler();
    buttonStart = findViewById(R.id.button);
    buttonStop = findViewById(R.id.button2);

    buttonStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            runnable.run();
        }
    });
    buttonStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            handler.removeCallbacks(runnable);
        }
    });

}

public Runnable runnable = new Runnable() {
    public void run() {
        generate();
        handler.postDelayed(runnable, 1500); // 1500 miliseconds
    }};

public void generate() {
    double min = 0.8;
    double max = 1.2;
    double number;
    Random rand = new Random();
    TextView myText = findViewById(R.id.textView_RanNum);

    number = rand.nextDouble() * max;
    String myString = String.valueOf(number);
    myText.setText(myString);
  }

}