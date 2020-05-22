reference.child(postid).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        Post post = dataSnapshot.getValue(Post.class);
        if (post != null) {
            double latitude = post.getLocation().getLatitude();
            double longitude = post.getLocation().getLongitude();

            ....
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});