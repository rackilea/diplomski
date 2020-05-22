public class MainActivity extends Activity implements OnClickListener {

    private static final long SUM_DELAY = 100;

    private TextView mResultView;
    private Button mStartButton;

    private Handler mHandler = new Handler();

    private int mSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultView  = (TextView) findViewById(R.id.resultView);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(this);
    }

    private Runnable sumTask = new Runnable() {

        @Override
        public void run() {

            mSum += 1;

            if (mSum > 120) {

                mSum = 0;
                mStartButton.setEnabled(true);

                return;
            }

            mResultView.setText(String.valueOf(mSum));

            mHandler.postDelayed(this, SUM_DELAY);
        }
    }; 

    @Override
    public void onClick(View view) {

        if (view.getId() == mStartButton.getId()) {

            mStartButton.setEnabled(false);
            sumTask.run();
        }
    }

}