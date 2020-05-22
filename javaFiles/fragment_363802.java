Animation animation = AnimationUtils.loadAnimation(MyApplication.getAppContext(), R.anim.shake);

    public void onClick(View v) {
        if (v.getId() == R.id.btnPlay) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Intent intent = new Intent(getActivity(), ArticleActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            v.startAnimation(animation);
        }
    }