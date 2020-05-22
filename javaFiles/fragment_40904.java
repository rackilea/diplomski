DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("Messages").child(my_Id).child(msgReceiverId).limitToLast(1);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Messages messages = dataSnapshot.getValue(Messages.class);
            String message = messages.getMessage();
            Log.d("TAG", message.getMessage());
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);