private int numberOfClicksOnRetryButton = 0;

...

retrybutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public synchronized void onClick(View v) {
        if (mInterstitialAd.isLoaded()) {
            numberOfClicksOnRetryButton++;
            if (numberOfClicksOnRetryButton == 3) {
                // This line is reached if the button has been clicked three times
                mInterstitialAd.show();
                numberOfClicksOnRetryButton = 0;
            }
        } else {
            ...
        }
    }
});