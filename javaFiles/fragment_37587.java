String modelKey = snapshot.getValue(String.class); 
DatabaseReference postRef = FirebaseDatabase.getInstance().getReference("Posts").child(modelKey);
postRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot postSnapshot) {
        PostModel save = postSnapshot.getValue(PostModel.class);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
}