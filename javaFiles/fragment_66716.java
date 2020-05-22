public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0, scoreTeamB = 0;
    TextView minutes; 
    TextView seconds; 
    long milliLeft, min, sec;
    CountDownTimer gameTime;
    Button timeoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minutes = (TextView) findViewById(R.id.min_counter);
        seconds = (TextView) findViewById(R.id.sec_counter);
        timeoutButton = (Button) findViewById(R.id.timeout_button);
    }