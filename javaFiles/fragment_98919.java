public PauseLayer() {
     super();
     RacingActivity activity = (RacingActivity) CCDirector.sharedDirector().getActivity();
     activity.revmob();

    CCSprite sprBg = CCSprite.sprite(PATH_BG + "pause_bg-ipad.png");
    this.addChild(sprBg);
    sprBg.setPosition(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2);

    GrowButton btnResume = GrowButton.buttonWithSpriteFileName(PATH_BTN
            + "btnResume-ipad.png", PATH_BTN + "btnResume-ipad.png",
            this, "onResume");
    this.addChild(btnResume);
    btnResume.setPosition(SCREEN_WIDTH / 2, 260 * 32 / 15);

    GrowButton btnReplay = GrowButton.buttonWithSpriteFileName(PATH_BTN
            + "btnReplay-ipad.png", PATH_BTN + "btnReplay-ipad.png",
            this, "onReplay");
    this.addChild(btnReplay);
    btnReplay.setPosition(SCREEN_WIDTH / 2, 220 * 32 / 15);

    GrowButton btnMenu = GrowButton.buttonWithSpriteFileName(PATH_BTN
            + "btnMenu1-ipad.png", PATH_BTN + "btnMenu1-ipad.png", this,
            "onMenu");
    this.addChild(btnMenu);
    btnMenu.setPosition(SCREEN_WIDTH / 2, 180 * 32 / 15);


   //Admon Interstitial

    interstitial = new InterstitialAd(activity);

    interstitial.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
    AdRequest adRequest = new AdRequest.Builder().build();
    interstitial.loadAd(adRequest);

    interstitial.setAdListener(new AdListener() {
        @Override
        public void onAdLoaded() {
            displayInterstitial();
        }
    });


 }