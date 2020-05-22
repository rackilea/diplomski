public class MainActivity extends FragmentActivity implements HeadlessProgressFragment.ProgressListener {

private static final String TAG = "progress_fragment";
private ProgressBar mProgressBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dummy_view);
    mHeadlessProgressFragment = (HeadlessProgressFragment) getSupportFragmentManager().findFragmentByTag(TAG);
    if (mHeadlessProgressFragment == null) {
        mHeadlessProgressFragment = new HeadlessProgressFragment();
        getSupportFragmentManager().beginTransaction().add(mHeadlessProgressFragment,TAG).commit();
    }
    mHeadlessProgressFragment.setProgressListener(this);
    mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
    final Button startFillBtn = (Button) findViewById(R.id.btn_start_filling);
    startFillBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mHeadlessProgressFragment.startProgress(100);
        }
    });
}

    @Override
    public void updateProgress(int progress) {
        mProgressBar.setProgress(progress);
    }
}