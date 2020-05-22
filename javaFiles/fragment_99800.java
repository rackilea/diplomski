private void continue(){

    // Check if user is signed in (non-null) and update UI accordingly.
    SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if (currentUser != null && currentUser.getUid() != null
            && currentUser.getUid().equals(mPrefs.getString("UID", "DEFAULT"))) {
        Intent i = new Intent(mContext, SocialPage.class);
        startActivity(i);
    } else {
        Intent i = new Intent(mContext, Login.class);
        startActivity(i);
    }


}