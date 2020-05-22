yourAnimation.setAnimationListener(new AnimationListener() {

    public void onAnimationStart(Animation anim) {};

    public void onAnimationRepeat(Animation anim) {};

    public void onAnimationEnd(Animation anim) {
        linearLayout.removeView(imageView);
    };

});