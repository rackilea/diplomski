String uid = "a81b0dec-671e-4840-9977-e932274928fb";
DatabaseReference user = fb.child(uid);
user.addListenerForSingleValueEvent(new ValueEventListener() {
  public void onDataChange(DataSnapshot data) {
    Log.i("SINGLE VALUE EVENT", data.child("email").getValue(String.class));
  }
  public void onCancelled(FirebaseError error) {
    Log.e(TAG, error);
  }
});