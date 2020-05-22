public class HomeTabActivity extends TabActivity 
{
    private TabHost mTabHost = null;
    private Intent mIntent = null;
    private TabHost.TabSpec mTabSpec = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hometab); 
        initializeTabs();
    }

    private void initializeTabs() {
        mTabHost = getTabHost();

        mIntent = new Intent().setClass(this, Tab1.class);
        mTabSpec = mTabHost
                .newTabSpec("Tab1")
                .setIndicator("Tab1",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);

        mIntent = new Intent().setClass(this, Tab2.class);
        mTabSpec = mTabHost
                .newTabSpec("Tab2")
                .setIndicator("Tab2",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);

        mTabHost.setCurrentTab(0);
    }

}