NativeFragment nativeFragment = null;

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.native_chat) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (nativeFragment == null) {
            // fragment doesn't exist, lets create and add one
            nativeFragment = new NativeFragment();
            getFragmentManager().executePendingTransactions();
            fragmentTransaction.add(R.id.FragmentContainer, nativeFragment);
        }

        if(nativeFragment.isVisible()){
            fragmentTransaction.hide(nativeFragment);
        } else {
            fragmentTransaction.show(nativeFragment);
        }
        fragmentTransaction.commit();

    } else if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}