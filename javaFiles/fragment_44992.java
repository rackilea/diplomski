public class TestActivity extends ActionBarActivity {


private static final int DELAY = 5000;

public boolean inactive;

Handler mHideHandler = new Handler();
Runnable mHideRunnable = new Runnable() {        
    @Override
    public void run() {            
        if(inactive) {
            finish();
        } else {
            mHideHandler.postDelayed(mHideRunnable, DELAY);
        }
    }
};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_annotation_test);
    mHideHandler.postDelayed(mHideRunnable, DELAY);

}
}