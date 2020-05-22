@SuppressLint("StringFormatInvalid")    
private void updateUI(FirebaseUser user) {

hideProgressDialog();

if (user != null) {
    mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,     user.getEmail()));
    mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));


   loginbutton.setVisibility(View.GONE);
   signupbutto.setVisibility(View.GONE);
   mStatusTextView.setVisibility(View.GONE);
   mDetailTextView.setVisibility(View.GONE);
   signoutbutton.setVisibility(View.VISIBLE);
} else {
   mStatusTextView.setText(R.string.signed_out);
   mDetailTextView.setText(null);

   loginbutton.setVisibility(View.VISIBLE);
   signupbutton.setVisibility(View.VISIBLE);
   mStatusTextView.setVisibility(View.GONE);
   mStatusTextView.setVisibility(View.GONE);
   signoutbutton.setVisibility(View.GONE);
}
}