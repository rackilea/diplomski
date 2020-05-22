sectionReference.child(classID).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
            uidArrayList.add(snapshot.getKey());
        }

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //getUIDsInCurrentClass();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    if(user.getRole().equals("student") && uidArrayList.contains(user.getUid())){
                        studentArrayList.add(user);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }
    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
});