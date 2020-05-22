DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference eventRef = rootRef.child("Student").child(student_id).child("event");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String reminddate = ds.child("reminddate").getValue(String.class);
            String title = ds.child("title").getValue(String.class);
            Log.d("TAG", reminddate + " / " + title);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
eventRef.addListenerForSingleValueEvent(eventListener);