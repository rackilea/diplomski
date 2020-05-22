public void setUp(int fragmentId, DrawerLayout drawerLayout, ArrayList<String> array) {
    mFragmentContainerView = getActivity().findViewById(fragmentId);
    mDrawerLayout = drawerLayout;

    Log.i("NavTesting", array.toString());


    mDrawerListView.setAdapter(new ArrayAdapter<String>(
            getActionBar().getThemedContext(),
            android.R.layout.simple_list_item_activated_1,
            android.R.id.text1,
            array));
    mDrawerListView.setItemChecked(mCurrentSelectedPosition, true);