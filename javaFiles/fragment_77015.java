@SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {          
            Fragment fragment = null;    
            int id = item.getItemId();    
            switch (id) {
                case R.id.nav_camera:                    
                    fragment = new FirstFragment();
                    break;
                case R.id.nav_gallery:
                    fragment = SecondFragment();
                    break;
                case R.id.nav_slideshow:

                    break;
                case R.id.nav_manage:

                    break;
                case R.id.nav_share:

                    break;
            }                                
            FragmentManager fragmentManager = getSupportFragmentManager();
            Bundle bundle = new Bundle();
            bundle.putString("1",String.valueOf(getMapLastIntent().get("aries")));
            fragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();       
            item.setChecked(true);        
            setTitle(item.getTitle());

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }