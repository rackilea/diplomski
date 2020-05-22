@Override
    protected void onCreate(Bundle savedInstanceState) {


        final SharedPref sharedPref;
        sharedPref = new SharedPref(this);

        if (sharedPref.loadNightModeState()) {
            setTheme(R.style.AppTheme_Night);
            //restartApp();
            //getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.actionbar));
            //actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.BackgroundLight));
        } else setTheme(R.style.AppTheme);
        //restartApp();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);