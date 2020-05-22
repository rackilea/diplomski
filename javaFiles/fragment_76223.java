/**
 * move to next slide.
 */
public void moveNextPosition(boolean smooth) {

    if (getRealAdapter() == null)
        throw new IllegalStateException("You did not set a slider adapter");

    mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, smooth);
}

// ...

/**
 * move to prev slide.
 */
public void movePrevPosition(boolean smooth) {

    if (getRealAdapter() == null)
        throw new IllegalStateException("You did not set a slider adapter");

    mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1, smooth);
}