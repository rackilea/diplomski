public class Test extends Activity {
    private final Handler mHandler = new Handler();
    private TextView mTest;

    private Runnable mTask = new Runnable() {
        public void run() {
            mTest.setText("task function run");
        }
    };

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTest = (TextView) findViewById(R.id.test);
        mHandler.postDelayed(mTask, 5000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mTask);
    }
}