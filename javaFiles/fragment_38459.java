public class NavigationDrawerFragment extends Fragment {

    private ArrayList<String> mArray;

    //......

    public void updateArray(ArrayList<String> array){

        Log.i("NavTesting", array.toString());

        mArray = array;

    }

    //......

    private void selectItem(int position) {

        if (mArray != null){
             Log.i("NavTestingSelectItem", mArray.toString());
        }


        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position);
        }
    }