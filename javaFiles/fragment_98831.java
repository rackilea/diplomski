ScaleAnimation animate = new ScaleAnimation(1,1,1,2);
animate.setDuration(1000);
animate.fillAfter(true);
animate.setAnimationListener(new AnimationListener() {

    @Override
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation animateAgain = new ScaleAnimation(1,1,2,1);
        animateAgain.setDuration(1000);
        animateAgain.fillAfter(true);
        view.startAnimation(animateAgain);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }});

view.startAnimation(animate);