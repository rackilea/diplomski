AdView ad = (AdView) findViewById(R.id.adView);
//Set the Ad Size    
ad.setAdSize(AdSize.BANNER);
 //Set the Banner Id
ad.setAdUnitId(YOUR_BANNER_ID);    
AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        ad.loadAd(adRequest);