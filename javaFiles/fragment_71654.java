public boolean onOptionsItemSelected(MenuItem item) {
    if (item != null && item.getItemId() == ID_HOME && mDrawerIndicatorEnabled) {
        if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }
    return false;
}