@Override
public boolean onNavigationItemSelected(MenuItem menuItem) {
    switch (menuItem.getItemId()) {
        case R.id.dhome:
            objFragment = new panel();
            mCurrentSelectedPosition = 0;
            break;
        case R.id.dsetting:
            mCurrentSelectedPosition = 1;
            break;
        case R.id.dlogout:
            mCurrentSelectedPosition = 2;
            break;
    }

    // update the main content by replacing fragments
    if(objFragment != null) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                       .replace(R.id.container, objFragment)
                       .commit();
    }

    return true;
}