@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.navigation_drawer, menu);
    return true;
}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

         if (id == R.id.action_refresh) {
        // add this line in your activity 


      ((FoodViewFragment)selectedFragment).yourServerCallMethodInF‌​ragment();
            return true;
        }

return super.onOptionsItemSelected(item);
}