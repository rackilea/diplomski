public boolean onNavigationItemSelected(MenuItem item) {



// Handle navigation view item clicks here.
int id = item.getItemId();

if (id == R.id.nav_home) {
    setTitle("Food View");

   selectedFragment = new FoodViewFragment();
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.content_frame,selectedFragment, "fragment1");
    fragmentTransaction.commit();


} else if (id == R.id.nav_food) {

} else if (id == R.id.nav_money) {

} else if (id == R.id.nav_settings) {

} else if (id == R.id.nav_about) {

} else if (id == R.id.nav_notifications) {

}


DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
drawer.closeDrawer(GravityCompat.START);
return true;
}