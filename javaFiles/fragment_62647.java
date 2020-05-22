private AdView adView;  // set as global

@Override
public void onCreate(Bundle savedInstanceState) {
 ...
  adView = new AdView(this, "YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50);  // initialize it

  LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

  adContainer.addView(adView);

  adView.loadAd();
}