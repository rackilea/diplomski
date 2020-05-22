private Single<User> getUser(String user_uid) {
    DatabaseReference db_users = db_root.child("Users");
    return Single.create(emitter -> {
        db_users.child(each_uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String uid = dataSnapshot.getKey();
                String image = dataSnapshot.child("image").getValue(String.class);
                String username = dataSnapshot.child("username").getValue(String.class);
                User user = new User(username, null, image, uid);
                emitter.onSuccess(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                emitter.onError(databaseError);
            }
        });
    });
}