public void fade(View view) {
    ImageView bale = (ImageView) findViewById(R.id.bale);
    ImageView pogba = (ImageView) findViewById(R.id.pogba);

    // I'm not familiar with the method to get the alpha
    // so it might not be getAlpha()
    bale.animate().alpha(1f - bale.getAlpha()).setDuration(2000);
    pogba.animate().alpha(1f - pogba.getAlpha()).setDuration(2000);
}