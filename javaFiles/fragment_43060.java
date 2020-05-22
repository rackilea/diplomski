@Override
public void onDrawerClosed(View drawerView) {
    super.onDrawerClosed(drawerView);
    if (!isAdded()) {
        return;
    }

    mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

    Resources resources = getResources();
    float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, resources.getDisplayMetrics());
    DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) mDrawerListView.getLayoutParams();
    params.width = (int) (width);
    mDrawerListView.setLayoutParams(params);

    getActivity().invalidateOptionsMenu(); // calls onPrepareOptionsMenu()
}