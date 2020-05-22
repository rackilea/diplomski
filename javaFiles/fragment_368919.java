public class Starting extends ActionBarActivity {

private final String PREFERENCE_NAME = "ad_counter_preference";
private final String COUNTER_INTERSTITIAL_ADS = "ad_counter";
private int mAdCounter = 0;

private InterstitialAd mInterstitialAd;
private AdRequest mInterstitialAdRequest;
private AdRequest mBannerAdRequest;
private AdView mAdView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.second);

    loadInterstitialAd();
    loadBannerAd();

    SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    mAdCounter = preferences.getInt(COUNTER_INTERSTITIAL_ADS, 0);

    if (mAdCounter == 3) {
        // Load interstitial ad now
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
        mAdCounter = 0; //Clear counter variable
    } else {
        mAdCounter++; // Increment counter variable
    }

    // Save counter value back to SharedPreferences
    editor.putInt(COUNTER_INTERSTITIAL_ADS, mAdCounter);
    editor.commit();
}

private void loadInterstitialAd() {
    mInterstitialAdRequest = new AdRequest.Builder()
            .build();

    //interstitial
    mInterstitialAd = new InterstitialAd(this);

    // set the ad unit ID
    mInterstitialAd.setAdUnitId("Your Ad unit Id");

    // Load ads into Interstitial Ads
    mInterstitialAd.loadAd(mInterstitialAdRequest);
}

private void loadBannerAd() {
    mAdView = (AdView) findViewById(R.id.adView);
    mBannerAdRequest = new AdRequest.Builder()
            .build();
    mAdView.loadAd(mBannerAdRequest);
}

private void showInterstitial() {
    if (mInterstitialAd.isLoaded()) {
        mInterstitialAd.show();
    }
}

@Override
public void onPause() {
    if (mAdView != null) {
        mAdView.pause();
    }
    super.onPause();
}

@Override
public void onResume() {
    super.onResume();
    if (mAdView != null) {
        mAdView.resume();
    }
}

@Override
public void onDestroy() {
    if (mAdView != null) {
        mAdView.destroy();
    }
    super.onDestroy();
}}