@Override
public void onDrawerOpened(View drawerView) {
    if (mActionMode != null) {
        mActionMode.finish();
    }
}

@Override
public void onDrawerClosed(View drawerView) {
    if (mActionModeCallback != null) {
        startActionMode(mActionModeCallback);
    }
}