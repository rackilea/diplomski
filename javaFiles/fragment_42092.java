tabLayout.setupWithViewPager(pager);

            tabLayout.addOnTabSelectedListener(
                    new TabLayout.ViewPagerOnTabSelectedListener(pager) {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            super.onTabSelected(tab);
                            pager.setCurrentItem(tab.getPosition());
                            Log.i("TAG", "onTabSelected: " + tab.getPosition());

                        }
                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });

            final PagerAdapter mAdapter = new MainPagerAdapter(getSupportFragmentManager());
            pager.setAdapter(mAdapter);
  tabLayout.setupWithViewPager(pager);