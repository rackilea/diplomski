mInterstitialAd.setAdListener(new AdListener() {

    @Override
    public void onAdClosed() {
        loadIntersitialAd();
     }

     @Override
     public void onAdFailedToLoad(int i) {

     }

     @Override
     public void onAdLeftApplication() {

     }

     @Override
     public void onAdOpened() {

     }

     public void onAdLoaded() {

     }
  });

private void loadIntersitialAd(){

    AdRequest interstitialRequest = new AdRequest.Builder().build();
    mInterstitialAd.loadAd(interstitialRequest);
}