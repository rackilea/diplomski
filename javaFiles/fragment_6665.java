private void setupViewPager(ViewPager viewPager,Bundle bundle) {
        ...
        Fragment fragmentOne=new OneFragment();
        fragmentOne.setArguments(bundle);
        adapter.addFragment(fragmentOne, "Description");
        // do same for second Framgment
   }