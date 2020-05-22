super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);

   // super.onCreate(savedInstanceState);

    // Checking for first time launch - before calling setContentView()
    prefManager = new slidingScreenLauncher(this);
    if (!prefManager.isFirstTimeLaunch()) {
        launchHomeScreen();
        finish();
    }

    // Making notification bar transparent
    if (Build.VERSION.SDK_INT >= 21) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

   // setContentView(R.layout.activity_welcome);