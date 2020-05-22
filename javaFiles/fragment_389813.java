navigationView.setNavigationItemSelectedListener(new 
NavigationView.OnNavigationItemSelectedListener() {   

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {

   int id = item.getItemId();

    if (id == R.id.nav_camera) {
        // Handle the camera action
        i=new Intent(youractivity.this,youractivity);
        startActivity(i);
    } else if (id == R.id.nav_gallery) {
        i=new Intent(youractivity.this,youractivity);
        startActivity(i);
    } else if (id == R.id.nav_slideshow) {
        //same
    } else if (id == R.id.nav_manage) {
        //same
    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }

 return true;
            }

        });