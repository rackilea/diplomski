// Load an ad into the AdMob banner view.
AdView adView = (AdView) findViewById(R.id.adView);
AdRequest adRequest = new AdRequest.Builder()
        .setRequestAgent("android_studio:ad_template").build();
adView.loadAd(adRequest);

// Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();