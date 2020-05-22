Fragment mFragmentToSet = null;

@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    // Handle navigation view item clicks here.
    switch (item.getItemId()) {
        case R.id.nav_home:
            mFragmentToSet = HomeFragment.newInstance(); 
            break;
    }

    mDrawerLayout.closeDrawer(GravityCompat.START);
    return true;
}