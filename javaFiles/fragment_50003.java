private static void fadeIn(long duration, final View... views) {
    if (views == null) return;
    final ValueAnimator va = ValueAnimator.ofFloat(0, 1);
    va.setDuration(duration);
    va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animator) {
            final float alpha = (float) animator.getAnimatedValue();
            for (View view : views) view.setAlpha(alpha);
        }
    });
    va.start();
}