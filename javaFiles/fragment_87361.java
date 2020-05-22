public class ProgressDrawerListener implements DrawerLayout.DrawerListener {
private final List<ProgressAnimator> mAnimatingMenuItems = new ArrayList<>();
private final Toolbar mToolbar;
private final ActionBarDrawerToggle mDrawerToggle;
private DrawerLayout.DrawerListener mDrawerListener;
private MenuItemAnimation mMenuItemAnimation;
private Animation mAnimation;
private boolean started;
private boolean mOpened;
private Activity mActivity;
private boolean mInvalidateOptionOnOpenClose;

public ProgressDrawerListener(Toolbar mToolbar, ActionBarDrawerToggle mDrawerToggle) {
    this.mToolbar = mToolbar;
    this.mDrawerToggle = mDrawerToggle;
}

@Override
public void onDrawerOpened(View view) {
    mDrawerToggle.onDrawerOpened(view);
    clearAnimation();
    started = false;

    if (mDrawerListener != null) {
        mDrawerListener.onDrawerOpened(view);
    }
    mToolbar.getMenu().setGroupVisible(0, false); //TODO not always needed
    mOpened=true;
    mActivity.invalidateOptionsMenu();
}

@Override
public void onDrawerClosed(View view) {
    mDrawerToggle.onDrawerClosed(view);
    clearAnimation();
    started = false;

    if (mDrawerListener != null) {
        mDrawerListener.onDrawerClosed(view);
    }
    mOpened=false;
    mActivity.invalidateOptionsMenu();
}

@Override
public void onDrawerStateChanged(int state) {
    mDrawerToggle.onDrawerStateChanged(state);
    switch (state) {
        case DrawerLayout.STATE_DRAGGING:
        case DrawerLayout.STATE_SETTLING:
            if (mAnimatingMenuItems.size() > 0 || started) {
                break;
            }
            started = true;

            setupAnimation();
            break;
        case DrawerLayout.STATE_IDLE:
            clearAnimation();
            started = false;
            break;
    }

    if (mDrawerListener != null) {
        mDrawerListener.onDrawerStateChanged(state);
    }
}

private void setupAnimation() {
    mToolbar.getMenu().setGroupVisible(0, true); //TODO not always needed
    mAnimatingMenuItems.clear();
    for (int i = 0; i < mToolbar.getChildCount(); i++) {
        final View v = mToolbar.getChildAt(i);
        if (v instanceof ActionMenuView) {
            int menuItemCount = 0;
            int childCount = ((ActionMenuView) v).getChildCount();
            for (int j = 0; j < childCount; j++) {
                if (((ActionMenuView) v).getChildAt(j) instanceof ActionMenuItemView) {
                    menuItemCount++;
                }
            }
            for (int j = 0; j < childCount; j++) {
                final View innerView = ((ActionMenuView) v).getChildAt(j);
                if (innerView instanceof ActionMenuItemView) {
                    MenuItem mMenuItem = ((ActionMenuItemView) innerView).getItemData();
                    ProgressAnimator offsetAnimator = new ProgressAnimator(mToolbar.getContext(), mMenuItem);

                    if(mMenuItemAnimation!=null) {
                        mMenuItemAnimation.setupAnimation(mMenuItem, offsetAnimator, j, menuItemCount);
                    }
                    if(mAnimation!=null) {
                        mAnimation.setupAnimation(offsetAnimator);
                    }

                    offsetAnimator.start();
                    mAnimatingMenuItems.add(offsetAnimator);
                }
            }
        }
    }
    onDrawerSlide(null, mOpened ? 1f : 0f);
    Log.e(getClass().getSimpleName(), "setupAnimation: "+mAnimatingMenuItems.size()); //TODO
}

@Override
public void onDrawerSlide(View view, float slideOffset) {
    for (ProgressAnimator ani : mAnimatingMenuItems) {
        ani.updateProgress(slideOffset);
    }

    if(view==null) {
        return;
    }
    mDrawerToggle.onDrawerSlide(view, slideOffset);

    if (mDrawerListener != null) {
        mDrawerListener.onDrawerSlide(view, slideOffset);
    }
}

private void clearAnimation() {
    for (ProgressAnimator ani : mAnimatingMenuItems) {
        ani.end();
    }
    mAnimatingMenuItems.clear();
}

public void setDrawerListener(DrawerLayout.DrawerListener mDrawerListener) {
    this.mDrawerListener = mDrawerListener;
}

public MenuItemAnimation getMenuItemAnimation() {
    return mMenuItemAnimation;
}

public void setMenuItemAnimation(MenuItemAnimation mMenuItemAnimation) {
    this.mMenuItemAnimation = mMenuItemAnimation;
}

public Animation getAnimation() {
    return mAnimation;
}

public void setAnimation(Animation mAnimation) {
    this.mAnimation = mAnimation;
}

public void setmInvalidateOptionOnOpenClose(Activity activity, boolean invalidateOptionOnOpenClose) {
    mActivity=activity;
    mInvalidateOptionOnOpenClose = invalidateOptionOnOpenClose;
}

public interface MenuItemAnimation {

    public void setupAnimation(MenuItem mMenuItem, ProgressAnimator offsetAnimator, int itemIndex, int menuCount);
}

public interface Animation {

    public void setupAnimation(ProgressAnimator offsetAnimator);
}