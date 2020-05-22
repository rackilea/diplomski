(new Thread() {
            public void run() {
                 Looper.prepare();
                adView.loadAd(new AdRequest());
            }
        }).start();