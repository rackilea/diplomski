NavigationView navigationView;
    DrawerLayout drawerLayout;

       @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            navigationView = findviewbyid(R.id.nav_drawer_home);
            drawerLayout = findviewbyid(R.id.drawer_home);

            drawerLayout.requestLayout();
            setUpNavigationView();
        }

        private void setUpNavigationView() {
            navigationView.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_recharge:
                    break;
                case R.id.nav_offers:
                    break;
                case R.id.nav_rides:
                    break;
                case R.id.nav_refer_friend:
                    break;
                case R.id.nav_wallet:
                    break;
                case R.id.nav_about_us:
                    break;
                case R.id.nav_feedback:
                    break;
                default:
                    break;
            }
            if (menuItem.isChecked())
                menuItem.setChecked(false);
            else
                menuItem.setChecked(true);
            menuItem.setChecked(true);

            drawerLayout.closeDrawers();

            return true;
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

   @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
}