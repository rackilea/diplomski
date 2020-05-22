mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
int fragmentCount = 2; // save value if it's a arbitrary list of fragments
for (int index = 0; i < fragmentCount; i++) {
    FirstFragment firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.view_pager, index));
    if (firstFragment == null) {
        firstFragment = FirstFragment.newInstance(mFeedItem);
    }
    mAdapter.addFrag(firstFragment, "someTitle");
}