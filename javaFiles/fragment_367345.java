AdRequest adRequest = new AdRequest.Builder()
  .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
  .build();

RelativeLayout relativeLayout = new RelativeLayout(this);
mFrameLayout.addView(relativeLayout);


RelativeLayout.LayoutParams adViewParams = new RelativeLayout.LayoutParams(
   AdView.LayoutParams.WRAP_CONTENT,
   AdView.LayoutParams.WRAP_CONTENT);
 // align bottom
adViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
 // align center
adViewParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);


relativeLayout.addView(adView, adViewParams);


adView.loadAd(adRequest);
adView.setBackgroundColor(Color.BLACK);
adView.setBackgroundColor(0);