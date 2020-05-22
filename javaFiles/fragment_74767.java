@Override
public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

    Comment newPost = dataSnapshot.getValue(Post.class);
    String postKey = dataSnapshot.getKey();
    newPost.setKey(postKey)
}