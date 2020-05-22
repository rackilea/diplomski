@Override
protected void onSaveInstanceState(Bundle savedInstanceState) {
    if (fragment1 != null) {
        savedInstanceState.putString(STORE_FRAGMENT1,
                fragment1.getTag());
    }
    if (fragment2 != null) {
        savedInstanceState.putString(STORE_FRAGMENT2,
                fragment2.getTag());
    }

    super.onSaveInstanceState(savedInstanceState);
}