ScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean stateAlive = getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)
                        if (stateAlive && mInterstitialAd.isLoaded()) {

                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "Ad not loaded");
                        }
                        prepareAD();
                    }
                });
            }
        }, 5, 5, TimeUnit.MINUTES);