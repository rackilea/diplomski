public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);

        final Handler handler = new Handler();
        Runnable runTimer = new Runnable()
        {
            @Override
            public void run() {
                mTextView.setText("Current Time: " + (new Date()).toString());
                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runTimer);
    }
}