@Override
public void onRewardedVideoAdRewarded(Placement placement) {
final Class2 cl2 = new Class2();

cl2.greyBackgroundcl2 = (ImageView) findViewById(R.id.greyBackgroundcl2);
cl2.adtextcl2 = (TextView)findViewById(R.id.adtextcl2);
cl2.showcl2 = (Button) findViewById(R.id.showVideocl2);

MainActivity.this.runOnUiThread(new Runnable() {
    @Override
    public void run() {
        cl2.showcl2.setVisibility(View.INVISIBLE);
        cl2.greyBackgroundcl2.setVisibility(View.INVISIBLE);
        cl2.adtextcl2.setVisibility(View.INVISIBLE);

    }
});
}