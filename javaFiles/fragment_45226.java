Query query =  databaseReference.child("users").orderByChild("username").equalTo(charSequence.toString()); 
// Note: Above provide your order of children this is just an example

query.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {...