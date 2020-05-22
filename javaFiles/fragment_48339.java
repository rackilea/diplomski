listener = new AdColonyInterstitialListener() {
    @Override
    public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
        ad = adColonyInterstitial;
    }
};