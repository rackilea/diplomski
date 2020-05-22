public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
       cfg.useGL20 = false;
       //setContentView(R.layout.main);
       RelativeLayout layout = new RelativeLayout(this);
       RelativeLayout.LayoutParams gameViewParams =
               new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                       RelativeLayout.LayoutParams.WRAP_CONTENT);
       //gameViewParams.bottomMargin = 150;
       requestWindowFeature( Window.FEATURE_NO_TITLE );
       View gameView = initializeForView(new ZBGame(), cfg);
       layout.addView(gameView, gameViewParams);

       AdView adView = new AdView(this);
       adView.setAdUnitId("my-ad-unit-here");
       adView.setAdSize(AdSize.BANNER);

       RelativeLayout.LayoutParams adParams = 
           new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                   RelativeLayout.LayoutParams.WRAP_CONTENT);
       adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
       adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

       layout.addView(adView, adParams);

       AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);

       setContentView(layout);    
    }