@Override
 public boolean onOptionsItemSelected(MenuItem item) {
     FragmentManager fragmentManager = getSupportFragmentManager();
     switch (item.getItemId()) {

         case R.id.about_settings:
             Log.d("tcc", "This is getting to the about fragment");
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.fragment_container, new HelpFragment());
             fragmentTransaction.addToBackStack(null); // to provided navigation when back is clicked
             fragmentTransaction.commit();
             return true;

         case R.id.help_settings:
             Log.d("tcc", "This is getting to the help fragment");

             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             fragmentTransaction.replace(R.id.fragment_container, new SettingsFragment());
             fragmentTransaction.addToBackStack(null); // to provided navigation when back is clicked
             fragmentTransaction.commit();
             return true;

         default:
             return super.onOptionsItemSelected(item);
     }
 }