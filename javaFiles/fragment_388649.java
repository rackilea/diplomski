@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);

    LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);

    // Create a banner ad
    mAdView = new AdView(this);
    mAdView.setAdSize(AdSize.SMART_BANNER);
    mAdView.setAdUnitId("myAdUnitId");

    // Create an ad request.
    AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

    // Optionally populate the ad request builder.
    adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);

    // Add the AdView to the view hierarchy.
    layout.addView(mAdView);

    // Start loading the ad.
    mAdView.loadAd(adRequestBuilder.build());

    setContentView(layout);
}