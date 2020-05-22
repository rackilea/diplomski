public static Animation blinkAnim() {

       // Configure your animation properties here

        Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(550);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(10);
        animation.setRepeatMode(Animation.REVERSE);
        return animation;
    }