anim.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
         Intent intent = new Intent(Animation_test.this, secondActivity.class);
         startActivity(intent);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});