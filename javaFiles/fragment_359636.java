@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract);

    mDrawerLayout.setDrawerShadow(R.drawable.navbar_shadow, GravityCompat.START);

    mTitle = mDrawerTitle = getTitle();
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mDrawerLayout.setDrawerShadow(R.drawable.navbar_shadow, Gravity.LEFT);/// it should be here after findviewbyid
    mLenear = (ScrollView)findViewById(R.id.leftDrawer);