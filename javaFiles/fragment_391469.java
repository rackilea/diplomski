/* We can override onBackPressed method to toggle navigation drawer*/
@Override
public void onBackPressed() {
    if(mDrawerLayout.isDrawerOpen(mDrawerList)){
        mDrawerLayout.closeDrawer(mDrawerList);
    }
}