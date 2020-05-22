mSwitch = true; // as its OK
for (DataSnapshot ds : dataSnapshot.getChildren()) {
  if(name.equals(ds.child("username").getValue(String.class))){
    mSwitch = false;
    Username.setError("Username Taken");
    Username.requestFocus();
    break;
  }
}

...
if (mSwitch) startActivity();
else showErrorToast();