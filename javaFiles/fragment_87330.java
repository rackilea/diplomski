@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
         boolean isLoggedIn = data.getBooleanExtra("isLoggedIn");
    }
}