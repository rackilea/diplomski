@Override
protected void onStart() {
    super.onStart();
    if (!prefs.getBoolean(Constants.IS_LOGGED_IN, false)){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Toast.makeText(getBaseContext(), "Please login to proceed", Toast.LENGTH_SHORT).show();
        startActivity(intent); 
    }
}