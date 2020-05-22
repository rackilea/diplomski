@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        // This is first step.
        showPopup(); 
        return true;
    }
    return super.onOptionsItemSelected(item);
}

// first step helper function
private void showPopup() {
    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
    alert.setMessage("Are you sure?")
            .setPositiveButton("Logout", new DialogInterface.OnClickListener()                 {

                public void onClick(DialogInterface dialog, int which) {

                    logout(); // Last step. Logout function

                }
            }).setNegativeButton("Cancel", null);

    AlertDialog alert1 = alert.create();
    alert1.show();
}

private void logout() {
    startActivity(new Intent(this, LoginActivity.class));
    finish();
}