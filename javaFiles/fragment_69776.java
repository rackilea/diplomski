@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_avisos);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        Intent intent = getIntent();
        //----edit-------

        String TagFragment1;
        String TagFragment2;
        if (savedInstanceState != null) {
                    FragmentManager fm = getSupportFragmentManager();
            TagFragment1 = savedInstanceState.getString(STORE_FRAGMENT1);
            fragment1 = (SubjectFragment) fm
                    .findFragmentByTag(TagFragment1);
            TagFragment2 = savedInstanceState.getString(STORE_FRAGMENT2);
            fragment2 = (CircuitFragment) fm
                    .findFragmentByTag(TagFragment2);

        }
        else {
            fragment1 = new Fragment1();
            fragment2 = new Fragment2();
        }
        //---end--edit-----
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        actionBar.addTab(actionBar.newTab().setText("Frag1 Tab").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Frag2 Tab").setTabListener(this));
    }