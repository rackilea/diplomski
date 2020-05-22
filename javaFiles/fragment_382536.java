moveLeft.setAnimationListener(new Animation.AnimationListener() {

        private int mCount = 0;

        @Override
        public void onAnimationStart(Animation animation) {
            mCount = count;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            terrainArray.get(mCount - 1).setVisibility(View.GONE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });