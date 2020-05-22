private Animator getViewScaleAnimator(View from, final View target) {
        // height resize animation
        AnimatorSet animatorSet = new AnimatorSet();
        int desiredHeight = from.getHeight();
        int currentHeight = target.getHeight();
        ValueAnimator heightAnimator = ValueAnimator.ofInt(currentHeight, desiredHeight);
        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) target.getLayoutParams();
                params.height = (int) animation.getAnimatedValue();
                target.setLayoutParams(params);
            }
        });
        animatorSet.play(heightAnimator);

        // width resize animation
        int desiredWidth = from.getWidth();
        int currentWidth = target.getWidth();
        ValueAnimator widthAnimator = ValueAnimator.ofInt(currentWidth, desiredWidth);
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) target.getLayoutParams();
                params.width = (int) animation.getAnimatedValue();
                target.setLayoutParams(params);
            }
        });
        animatorSet.play(widthAnimator);
        return animatorSet;
    }