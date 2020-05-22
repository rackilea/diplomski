public class FragHandler extends AppCompatActivity 
    TabLayout tabLayout;
    Toolbar customtoolbar;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alstabopener);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final AlsViewChanger adapter = new AlsViewChanger(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        int tabToSelect = getIntent().getIntExtra("Settings”, 0);
        viewPager.setCurrentItem(tabToSelect);
    }

}