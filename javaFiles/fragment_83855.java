mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                newDrawable, R.string.app_name,
                newDrawable) {

    public void onDrawerClosed(View drawerView) {
    };

    public void onDrawerOpened(View drawerView) {
    };

};

mDrawerLayout.setDrawerListener(mDrawerToggle);
mDrawerToggle.syncState();