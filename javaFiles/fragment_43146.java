mInterstitialAd = new InterstitialAd(this);

    // set the ad unit ID
    mInterstitialAd.setAdUnitId(InterstitialAd_ID);

    AdRequest adRequest = new AdRequest.Builder().build();

    // Load ads into Interstitial Ads
    mInterstitialAd.loadAd(adRequest);


    mInterstitialAd.setAdListener(new AdListener() {

        @Override
        public void onAdClosed() {
            super.onAdClosed();
        }

        @Override
        public void onAdFailedToLoad(int i) {
            super.onAdFailedToLoad(i);    
        }

        @Override
        public void onAdLeftApplication() {
            super.onAdLeftApplication();    
        }

        @Override
        public void onAdOpened() {
            super.onAdOpened();
        }

        public void onAdLoaded() {
            if (mInterstitialAd.isLoaded()) {
            }   
        }
    });