LinearLayout details = findViewById(R.id.details);

ValueAnimator animator = ValueAnimator.ofFloat(0.3f, 0.8f);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float value = (float) animation.getAnimatedValue();

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) details.getLayoutParams();
        params.weight = value;
        details.setLayoutParams(params);
    }
});