public class MainActivity extends Activity implements ActionBar.TabListener {

    private int mFragmentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // For each of the sections in the app, add a tab to the action bar.
        mFragmentCount = 3;
        for (int i = 0; i < mFragmentCount; i++) {
            // Create a tab with text Also specify this Activity object, which
            // implements the TabListener interface, as the callback (listener)
            // for when this tab is selected.
            actionBar.addTab(actionBar.newTab().setText("Tab " + i).setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // Switch fragments
        // use fragmentTransaction methods with R.id.activity_root for the container id
        // don't call commit(), it will be called for you
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {}
}