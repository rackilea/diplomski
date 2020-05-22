view.animate()
        .translationY(view.getHeight())
        .alpha(0.0f)
        .setDuration(300)
        .setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.GONE);
            }
        });