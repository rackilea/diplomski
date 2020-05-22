public class Tab1 extends TabActivity 
{
    private TabHost mTabHost = null;
    private Intent mIntent = null;
    private TabHost.TabSpec mTabSpec = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);
        initializeTabs();
    }

    private void initializeTabs() {
        mTabHost = getTabHost();
        mIntent = new Intent().setClass(this, FirstTab.class);

        mTabSpec = mTabHost
                .newTabSpec("Tab1 Child 1")
                .setIndicator("Tab1 Child 1",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);

        mIntent = new Intent().setClass(this, SecondTab.class);
        mTabSpec = mTabHost
                .newTabSpec("Tab1 Child 2")
                .setIndicator("Tab1 Child 2",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);
        mTabHost.setCurrentTab(0);
    }
}