User user = dataSnapshot.getValue(User.class);

if(user == null) {
  // data not found
  return;
}

// check for non null user name
if(user.getUsername != null) {
  profileuser.setText(user.getUsername());
}

// check for non null image url
if(user.getImageURL() != null) {
  if (user.getImageURL().equals("default")){
    ...
  }
}