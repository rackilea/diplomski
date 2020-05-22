mAnimation = new TranslateAnimation(0, 599, 0, 0);
    mAnimation.setDuration(10000);
    mAnimation.setFillAfter(true);
    mAnimation.setRepeatCount(-1);
    mAnimation.setRepeatMode(Animation.REVERSE);
    view.setAnimation(mAnimation);