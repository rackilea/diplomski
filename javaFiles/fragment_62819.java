tabLayout.setOnTabSelectedListener(
  new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        super.onTabSelected(tab);
        // Do your login here.. according to tab positon
    }
});