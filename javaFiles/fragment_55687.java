public void onWindowFocusChanged(boolean hasFocus) {
bground = (ImageView)findViewById(R.id.background);
bground.setImageResource(R.drawable.bowanimbg);
bganim = (AnimationDrawable) bground.getBackground();
if (hasFocus) {
    bganim.start();
} 
else {
    bganim.stop();
}