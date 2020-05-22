...
if (!isInTwoPaneMode()) {           
    if (savedInstanceState == null) {
        mFriendsFragment = new FriendsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, mFriendsFragment);
        transaction.commit();       
    }
}
...