public class Home extends FragmentActivity {

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private static final String TAB_4_TAG = "tab_4";
    private static final String TAB_5_TAG = "tab_5";
    private FragmentTabHost mTabHost;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home);
        initView();
        view = (View) findViewById(R.drawable.tab_indicator);
        // setTabs();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec(TAB_1_TAG).setIndicator("",
                        getResources().getDrawable(R.drawable.tab_select_talk)),
                TalkContainerFragment.class, null);
        // mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("Talk"),
        // TalkContainerFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(TAB_2_TAG).setIndicator("",
                        getResources().getDrawable(R.drawable.tab_select_learn)),
                LearnContainerFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(TAB_3_TAG).setIndicator("",
                        getResources().getDrawable(R.drawable.tab_select_go)),
                GoContainerFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(TAB_4_TAG).setIndicator("",
                        getResources().getDrawable(R.drawable.tab_select_watch)),
                WatchContainerFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(TAB_5_TAG).setIndicator("",
                        getResources().getDrawable(R.drawable.tab_select_more)),
                MoreContainerFragment.class, null);

        // Inflating color for the first time.
        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            mTabHost.getTabWidget().getChildAt(i)
                    .setBackgroundColor(Color.parseColor("#181818"));
        }

        mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab())
                .setBackgroundColor(Color.parseColor("#424542"));
        // ============== End of color inflation ==================

        mTabHost.setOnTabChangedListener(new OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {

                // Inflating color when tab is selected.
                for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
                    mTabHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.parseColor("#181818"));

                }

                mTabHost.getTabWidget().getChildAt(mTabHost.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#424542"));
                // ============== End of color inflation ==================

            }
        });

        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            final TextView tv = (TextView) mTabHost.getTabWidget()
                    .getChildAt(i).findViewById(android.R.id.title);
            // mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.talk);
            if (tv == null)
                continue;
            else
                tv.setTextSize(8);

        }

    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();
        if (currentTabTag.equals(TAB_1_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager()
                    .findFragmentByTag(TAB_1_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_2_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager()
                    .findFragmentByTag(TAB_2_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_3_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager()
                    .findFragmentByTag(TAB_3_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_4_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager()
                    .findFragmentByTag(TAB_4_TAG)).popFragment();
        } else if (currentTabTag.equals(TAB_5_TAG)) {
            isPopFragment = ((BaseContainerFragment) getSupportFragmentManager()
                    .findFragmentByTag(TAB_5_TAG)).popFragment();
        }
        if (!isPopFragment) {
            finish();
        }
    }

}