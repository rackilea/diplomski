private void displayView(int position) {
    // update the main content by replacing fragments
    Fragment fragment = null;
    switch (position) {
        case 0:
            fragment = new HomeFragment();
            break;
        case 1:
            fragment = new FindPeopleFragment();
            break;
      default:
            break;
   }

 if (fragment != null) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        setTitle(navMenuTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }
    else
    {
        // error in creating fragment
        Log.e("MainActivity", "Error in creating fragment");
    }
}