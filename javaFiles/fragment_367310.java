Firebase userRef = new Firebase(/*url*/);
userRef = userRef.child("users");
userRef.addValueEventListener(new ValueEventListener(){
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot uniqueUserSnapshot : dataSnapshot.getChildren()) {
            ...
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});