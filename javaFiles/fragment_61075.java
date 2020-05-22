mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
        @Override public void onDrawerSlide(View drawerView, float slideOffset) {}
        @Override public void onDrawerOpened(View drawerView) {}
        @Override public void onDrawerStateChanged(int newState) {}

        @Override
        public void onDrawerClosed(View drawerView) {
          //Set your new fragment here
          if (mFragmentToSet != null) {
            getSupportFragmentManager()
                  .beginTransaction()
                  .replace(FRAGMENT_CONTAINER_ID, mFragmentToSet)
                  .commit();
            mFragmentToSet = null;
          }
        }
    });