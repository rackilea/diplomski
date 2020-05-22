final ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f); //start and end value
        valueAnimator.setDuration(2000); //you can replace 2000 with a variable you can change dynamically
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                button.setScaleX(animatedValue);
                button.setScaleY(animatedValue);
            }
        });
        valueAnimator.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAnimator.pause();
            }
        });