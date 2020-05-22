Parcelable p = getIntent().getExtras().getParcelable("thecontact");
if (p != null) {
   Contact userData = (Contact) p;
   txtUsername.setText(userData.getUsername());
   txtPassword.setText(userData.getPassword());
}