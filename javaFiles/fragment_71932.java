DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef
    .child("Employees")
    .child(mobileNumber) //Could be: 765432189
    .child(userPin) //Could be: 123457
    .orderBychild("empid")
    .equalsTo(enteredUserPIN);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            //Do something
        } else {
            //Do something else
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);