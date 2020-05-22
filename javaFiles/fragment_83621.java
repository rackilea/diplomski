public void onTabSelected(Tab tab, FragmentTransaction ft) {
    // Check if the fragment is already initialized
    if (mFirstTab == null) {
        // If not, instantiate and add it to the activity
        mFirstTab = Fragment.instantiate(mActivity, mClass.getName());
        ft.add(android.R.id.content, mFirstTab, mTag);
    } else {
        // If it exists, simply attach it in order to show it
        ft.attach(mFirstTab);
    }
}

public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    if (mFirstTab != null) {
        // Detach the fragment, because another one is being attached
        ft.detach(mFirstTab);
    }
}

public void onTabReselected(Tab tab, FragmentTransaction ft) {
    // User selected the already selected tab. Usually do nothing.
}