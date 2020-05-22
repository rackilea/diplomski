public class MainActivity extends AppCompatActivity {

private SectionsPagerAdapter mSectionsPagerAdapter;
private ViewPager mViewPager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    // Set up the ViewPager with the sections adapter.
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);

    getSupportActionBar().hide();
}

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return home.newInstance();
        } else if(position == 1) {
            return roman_numbers.newInstance();
        } else if(position == 2) {
            return binary_numbers.newInstance();
        }
        throw new IllegalArgumentException("There is no fragment for position [" + position + "]");
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return getString(R.string.fragment_home);
            case 1:
                return getString(R.string.fragment_roman_numbers);
            case 2:
                return getString(R.string.fragment_binary_numbers);
        }
        throw new IllegalArgumentException("There is no fragment for position [" + position + "]");
    }
}
}