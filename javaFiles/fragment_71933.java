DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference employeesRef = rootRef.child("Employees");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            if(ds.child(enteredUserPIN).exists()) {
                //Do something
            } else {
                //Do something else
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
employeesRef.addListenerForSingleValueEvent(valueEventListener);