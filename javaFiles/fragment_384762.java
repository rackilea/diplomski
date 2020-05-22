AdView mAdView;
mAdView = findViewById(R.id.adView);    
if("free".equals(BuildConfig.FLAVOR))
    {
      mAdView.setVisibility(View.VISIBLE);
      mAdView.loadAd(adRequest);
    }else{
      mAdView.setVisibility(View.GONE);
}