@Override
public void onRewardedVideoAdLoaded() {
    static int ONEHOUR = 60 * 60 * 1000;
    Toast.makeText(Competition.this, "Advert loaded please click the Reward button to continue", Toast.LENGTH_LONG).show();
    btn1 = (Button) findViewById(R.id.btncomp_ok);
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (System.currentTimeMillis() >= lastClickTime + ONEHOUR) {
                showRewardedVideo();
            }
        }
    });
}