private static final String APP_ID = "your_app_id"

 @Override
    protected void onCreate(Bundle savedInstanceState) {
Bundle adsInstanceState = (savedInstanceState != null)
                ? savedInstanceState.getBundle(APP_ID): null;
        super.onCreate(adsInstanceState);
MobileAds.initialize(this,APP_ID);
}

  @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle adsInstanceState = new Bundle();
        outState.putBundle(APP_ID, adsInstanceState )
   }