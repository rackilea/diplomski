@Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
                return;
             }

            if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof Article) {
                ((Article) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).handleOnBackPress();
                return;
            }

            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                displayView(R.id.nav_home);
            } else {
                super.onBackPressed();

            }
        }