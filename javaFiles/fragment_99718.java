interstitial.setAdListener(new AdListener() {
         @Override
         public void onAdLoaded() {
              displayInterstitial();   
         }

         @Override
         public void onAdClosed() {
              loadIntersitialAd();
         }
  });