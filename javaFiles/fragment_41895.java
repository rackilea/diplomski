DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference membersRef = rootRef.child(teachers).child(teacherId).child("members");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String userId = ds.key();

            DatabaseReference userIdRef = rootRef.child("users").child(userId);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    Log.d("TAG", user.getName());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            userIdRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
membersRef.addListenerForSingleValueEvent(valueEventListener);