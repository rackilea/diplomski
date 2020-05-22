AnimatorSet set = new AnimatorSet();
    set.playTogether(
        ObjectAnimator.ofFloat(myView, "rotationX", 0, 360),
        ObjectAnimator.ofFloat(myView, "translationX", 0, 90),
        ObjectAnimator.ofFloat(myView, "scaleX", 1, 1.5f),
        ObjectAnimator.ofFloat(myView, "alpha", 1, 0.25f, 1));
set.setDuration(5 * 1000).start();