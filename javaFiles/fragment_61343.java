final ImageView backgroundOne = (ImageView) findViewById(R.id.background_one);
final ImageView backgroundTwo = (ImageView) findViewById(R.id.background_two);

final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
animator.setRepeatCount(ValueAnimator.INFINITE);
animator.setInterpolator(new LinearInterpolator());
animator.setDuration(10000L);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        final float progress = (float) animation.getAnimatedValue();
        final float width = backgroundOne.getWidth();
        final float translationX = width * progress;
        backgroundOne.setTranslationX(translationX);
        backgroundTwo.setTranslationX(translationX - width);
    }
});
animator.start();