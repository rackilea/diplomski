MobileAds.initialize(activity.getApplicationContext(), APP_ID);
initView();

protected void initView(){

        // Create and setup the AdMobHelper view
        topView = new AdView(activity);
        topView.setAdSize(AdSize.BANNER);
        topView.setAdUnitId(TopAdUnitId);

        bottomView = new AdView(activity);
        bottomView.setAdSize(AdSize.BANNER);
        bottomView.setAdUnitId(BottomAdUnitId);

        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        //adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        topView.loadAd(adRequestBuilder.build());

        AdRequest.Builder adRequestBuilder1 = new AdRequest.Builder();
        adRequestBuilder1.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        bottomView.loadAd(adRequestBuilder1.build());

        crateInterestial();

        // Do the stuff that initialize() would do for you
        callForInitializeForView();

    }