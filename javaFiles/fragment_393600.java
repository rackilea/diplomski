mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_opened,R.string.drawer_closed)
    {
        @Override
        public void onDrawerOpened(View drawerView) {
            if (getSupportActionBar()!= null ) {
                getSupportActionBar().setTitle(R.string.drawer_opened);
            }
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
            if (getSupportActionBar()!= null ) {
                getSupportActionBar().setTitle(R.string.drawer_closed);
            }
        }
    };
    mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);