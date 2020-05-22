public void onClick(View v) {
    int i = v.getId();
    if (i == R.id.map) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    } else if (i == R.id.signOut) {

         FirebaseAuth.getInstance.signOut();
         Intent navigateIntent=new Intent(CurrentActivity.this,SecondActivity.class);
         startActivity(navigateIntent);
           //so that when you click the back button, you won't have to able to go back the previous activity
         finish();
    }

}
}