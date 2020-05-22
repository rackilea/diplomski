public void methodName(final Activity context) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    AdvertisingIdClientInfo.AdInfo adInfo = AdvertisingIdClientInfo.getAdvertisingIdInfo(context);
                    this._googleAdvertiserId = adInfo.getId();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }