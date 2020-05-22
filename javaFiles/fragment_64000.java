private void displayView(int position) {
    // update the main content by replacing fragments
    Fragment fragment = null;
    ListFragment listfragment = null;
    switch (position) {
    case 0:
        fragment = new HomeFragment();
        break;
    case 1:
        fragment = new MessaggiFragment();
        break;
    case 2:
        fragment = new OggettiSeguitiFragment();
        break;
    case 3:
        fragment = new OggettiAcquistatiFragment();
        break;
    case 4:
        fragment = new InVenditaFragment();
        break;
    case 5:
        fragment = new VendutiFragment();
        break;
    case 6:
        fragment = new InvendutiFragment();
        break;
    case 7:
        listfragment = new ItemListFragment();
        break;
    default:
        break;
    }     
    if (fragment != null) {
        // do stuff if it's a fragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment).commit();
    } else if (listfragment != null) {
        // do stuff if its a listfragment
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_container, listfragment).commit();
    } else {
        // error in creating fragment
        Log.e("MainActivity", "Error in creating fragment");
    }