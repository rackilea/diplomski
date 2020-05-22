adView.setAdListener(new AdListener() {
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLoaded() {
        showToast("Ad loaded.");
        if (adView.getVisibility() == View.GONE) {
            adView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        if (adView.getVisibility() == View.VISIBLE) {
            adView.setVisibility(View.GONE);
        }
    }

    @Override
    public void onAdOpened() {
        showToast("Ad opened.");
    }

    @Override
    public void onAdClosed() {
        showToast("Ad closed.");
    }

    @Override
    public void onAdLeftApplication() {
        showToast("Ad left application.");
    }
});