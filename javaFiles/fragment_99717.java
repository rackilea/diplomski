private InterstitialAd interstitial;
private AdView mAdView;
Button xxxx;

  @Override
  protected void onCreate (Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      xxxx = (Button)findViewById(R.id.xxxx);
      xxxx.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
             Intent xxxx = new Intent(MainActivity.this, xxxx.class);
             startActivity(xxxx);
           }
      });

      mAdView = (AdView) findViewById(R.id.adView);
      AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
      adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);  // for testing only
      mAdView.loadAd(adRequestBuilder.build()); 

      interstitial = new InterstitialAd(this);
      interstitial.setAdUnitId("ca-app-pub-8736194125011489/4511020459");
      interstitial.setAdListener(new AdListener() {
             @Override
             public void onAdLoaded() {}

             @Override
             public void onAdClosed() {
                  loadIntersitialAd();
             }
      });

      loadIntersitialAd();
  }

  private void loadIntersitialAd(){

      AdRequest interstitialRequest = new AdRequest.Builder().build();
      interstitial.loadAd(interstitialRequest);
  }

  public void displayInterstitial() {
     if (interstitial.isLoaded()) interstitial.show();
  }

  public boolean isInterstitialLoaded(){
    return interstitial.isLoaded();
  }

  @Override
  protected void onResume() {
    super.onResume();
    mAdView.resume();
  }

  @Override
  protected void onPause() {
    super.onPause();
    mAdView.pause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mAdView.destroy();
 }
}