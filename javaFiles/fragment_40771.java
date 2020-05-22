DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference seenByRef = rootRef.child("messages").child(messageId).child("seenBy");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long seenBy = dataSnapshot.getChildrenCount();
        Lod.d("TAG", "Seen by: " + seenBy);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
seenByRef.addListenerForSingleValueEvent(eventListener);