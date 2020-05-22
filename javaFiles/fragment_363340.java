public void showHistory(View v) {

        FrameLayout mainView = (FrameLayout) findViewById(R.id.mainView);
        AnimatorSet set = new AnimatorSet();
        // Using property animation
        ObjectAnimator animation = ObjectAnimator.ofFloat(mainView,
                "translationY", 0f, -0.8f);
            animation.setDuration(2000);
        set.play(animation);
        set.start();

    }