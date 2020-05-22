imageView.animate().setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        imageView.setImageResource(R.drawable.img_guitar);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});