@Override
   public boolean onOptionsItemSelected(MenuItem item) {        
    int id = item.getItemId();
    if (id == R.id.action_settings) {

       // USE HERE! DIALOG
       ResetAll dialog = new ResetAll();
       dialog.show(getSupportFragmentManager(), "restFragmentDialog");

// restFragmentDialog is a unique tag name that the system uses to save and restore the fragment state when necessary.
// The tag also allows you to get a handle to the fragment by calling findFragmentByTag().

    }
    return super.onOptionsItemSelected(item);
}