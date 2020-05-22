Post post = new Post();
for (DataSnapshot d: dataSnapshot.getChildren()){
    post= d.getValue(Post.class);
    Log.i("MV","AQUI"+post);
}
postsList.add(post);// <----------
postAdapter.notifyDataSetChanged();