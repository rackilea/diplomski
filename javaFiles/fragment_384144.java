public class Tab2 extends TabActivity 
{
    private TabHost mTabHost = null;
    private Intent mIntent = null;
    private TabHost.TabSpec mTabSpec = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2);
        initializeTabs();
    }

    private void initializeTabs() {
        mTabHost = getTabHost();
        mIntent = new Intent().setClass(this, ThirdTab.class);

        mTabSpec = mTabHost
                .newTabSpec("Tab2 Child 1")
                .setIndicator("Tab2 Child 1",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);

        mIntent = new Intent().setClass(this, FourthTab.class);
        mTabSpec = mTabHost
                .newTabSpec("Tab2 Child 2")
                .setIndicator("Tab2 Child 2",
                        getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(mIntent);
        mTabHost.addTab(mTabSpec);
        mTabHost.setCurrentTab(1);
    }
}