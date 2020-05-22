public class HomeActivity extends AppCompatActivity {

private SectionPageAdapter mSectionPageAdapter;
private ViewPager mViewPager;
private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Create the adapter that returns a fragment for each tab
        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        //Set up the view pager with different section adapters
        mViewPager = (ViewPager) findViewById(R.id.contentFrameLayout);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mSectionPageAdapter);
        mViewPager.setPagingEnabled(false);

        //Set up the tab layout to display tabs
        tabLayout = (TabLayout) findViewById(R.id.homeTabs);
        tabLayout.setupWithViewPager(mViewPager);

    //add icons to tabs and change the text behavior
    for (int i = 0; i< tabLayout.getTabCount(); i++) {

        TabLayout.Tab mTab = tabLayout.getTabAt(i);
        if (mTab != null) {
            switch (i){
                case 0:
                    mTab.setIcon(R.drawable.icon_zero);
                    break;
                case 1:
                    mTab.setIcon(R.drawable.icon_one);
                    break;
                case 2:
                    mTab.setIcon(R.drawable.icon_two);
                    break;
                default:
                    break;
            }
        }
    }
}


/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the tabs.
 */
private class SectionPageAdapter extends FragmentPagerAdapter {

    SectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return (MainContentFragment.newInstance());
            case 1:
                return (ScanItemFragment.newInstance());
            case 2:
                return (SettingFragment.newInstance());
            default:
                break;
        }

            return (null);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
}