public class ClockActivity extends Activity {

    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    private TextView mClock;
    private boolean mActive;
    private final Handler mHandler;

    private final Runnable mRunnable = new Runnable() {
        public void run() {
            if (mActive) {
                if (mClock != null) {
                    mClock.setText(getTime());
                }
                mHandler.postDelayed(mRunnable, 1000);
            }
        }
    };

    public ClockActivity() {
        mHandler = new Handler();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mClock = (TextView) findViewById(R.id.clock_textview);
        startClock();
    }

    private String getTime() {
        return sdf.format(new Date(System.currentTimeMillis()));
    }

    private void startClock() {
        mActive = true;
        mHandler.post(mRunnable);
    }
}