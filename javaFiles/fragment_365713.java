//as a field
FadeAnimationListener fadeAnimationListener = new FadeAnimationListener();

//inside a method
fadeOut.setAnimationListener(fadeAnimationListener);

//as a static or not inner class or a public high level class
private static class FadeAnimationListener implements AnimationListener {
    @Override
    public void onAnimationEnd(Animation animation) {
        //do your specific stuff here
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        //do your specific stuff here
    }

    @Override
    public void onAnimationStart(Animation animation) {
        //do your specific stuff here
    }
 }