mInterstitial.setAdListener(new AdListener() {
    @Override
    public void onAdLoaded() {
        // TODO Auto-generated method stub
        super.onAdLoaded();
        if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }
    }
});