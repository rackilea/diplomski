public class MenuActivity extends Activity {
    private FrameLayout mContainer;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Layout that has menu on top and an empty
        // FrameLayout below
        setContentView(R.layout.main);
        mContainer = (FrameLayout) findViewById(R.id.frame_layout);
        // add click listeners to menu and let them call
        // onMenuItemClicked() or whatever you wish to do
    }

    @Override
    public void setContentView(View view) {
        mContainer.removeAllViews();
        mContainer.addView(view);
    }

    protected void onMenuItemClicked(){ /* or abstract */ }
}