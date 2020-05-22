public void checkIfEmailExists(String userEmail, final UserCallback callback){
databaseReferenceUser.orderByChild("userEmail").equalTo(userEmail).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()){
            editTextEmailRegister.setError("Email already exists");
            editTextEmailRegister.requestFocus();
            callback.onUserExists(true);
        } else {
            callback.onUserExists(false);
        } 
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

// return isExist;  // this method is void now
}