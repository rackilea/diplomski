@Override
protected void onCreate(Bundle savedInstanceState) {
    //other init

    mProgressDrawerListener =new ProgressDrawerListener(toolbar, mDrawerToggle);
    mProgressDrawerListener.setmInvalidateOptionOnOpenClose(this, true);
    mOpenAnimation = new ProgressDrawerListener.MenuItemAnimation() {
        @Override
        public void setupAnimation(MenuItem mMenuItem, ProgressAnimator offsetAnimator, int itemIndex, int menuCount) {
            MainActivity.this.setupAnimation(true, offsetAnimator, itemIndex);
        }
    };
    mCloseAnimation = new ProgressDrawerListener.MenuItemAnimation() {
        @Override
        public void setupAnimation(MenuItem mMenuItem, ProgressAnimator offsetAnimator, int itemIndex, int menuCount) {
            MainActivity.this.setupAnimation(false, offsetAnimator, itemIndex);
        }
    };
    mDrawerLayout.setDrawerListener(mProgressDrawerListener);
}

//customize your animation here
private void setupAnimation(boolean open, ProgressAnimator offsetAnimator, int itemIndex) {
    AnimatorSet set = new AnimatorSet();
    set.playTogether(
            ObjectAnimator.ofFloat(null, "alpha", 1.0f, 0f),
            ObjectAnimator.ofFloat(null, "scaleX", 1.0f, 0f)
    );
    set.setStartDelay(itemIndex * 200);
    set.setDuration(1000 - itemIndex * 200); //not the actual time the animation will be played
    if(open) {
        offsetAnimator.addAnimatorSet(set, 0, 1);
    } else {
        offsetAnimator.addAnimatorSet(set, 1, 0);
    }
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Only show items in the action bar relevant to this screen
    // if the drawer is not showing. Otherwise, let the drawer
    // decide what to show in the action bar.
    if(mDrawerLayout.isDrawerOpen(findViewById(R.id.drawerList))) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        mProgressDrawerListener.setMenuItemAnimation(
                mCloseAnimation);
    } else {
        getMenuInflater().inflate(R.menu.main, menu);
        mProgressDrawerListener.setMenuItemAnimation(
                mOpenAnimation);
        mDrawerLayout.setDrawerListener(mProgressDrawerListener);
    }

    return super.onCreateOptionsMenu(menu);
}