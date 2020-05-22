@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_ols_home);

    // putting this line first instantiates the adView
    AdView adView = (AdView) this.findViewById(R.id.adView);

    adView = new AdView(this);
    adView.setAdSize(AdSize.SMART_BANNER);
    adView.setAdUnitId(AD_UNIT_ID);

    AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();

    adView.loadAd(adRequest);