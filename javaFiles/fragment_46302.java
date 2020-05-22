public void displayInterstitial() {
    // If Ads are loaded, show Interstitial(end_ad) else show nothing.
    if (end_ad.isLoaded()) {
        end_ad.show();
    }
}