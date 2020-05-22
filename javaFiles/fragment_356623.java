super.onCreate(savedInstanceState);
setContentView(R.layout.main_layout);
// Initializing tab and pager views
TabLayout tabLayout = (TabLayout) findViewById(R.id.my_tab_layout);
final ViewPager viewPager = (ViewPager) findViewById(R.id.my_view_pager);

// Making new tabs and adding to tabLayout
tabLayout.addTab(tabLayout.newTab().setText("First Tab"));
tabLayout.addTab(tabLayout.newTab().setText("Second Tab"));

// Adding fragments to a list
List<Fragment> fragments = new Vector<Fragment>();
fragments.add(Fragment.instantiate(this, MyFirstTabFragment.class.getName()));
fragments.add(Fragment.instantiate(this, MySecondTabFragment.class.getName()));

// Attaching fragments into tabLayout with ViewPager
viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager(), fragments));
tabLayout.setupWithViewPager(viewPager);