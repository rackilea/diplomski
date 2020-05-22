public void GetDataUpdates(DataSnapshot dataSnapshot ){
     SharedPosts.clear();

    for(DataSnapshot ds: dataSnapshot.getChildren()){

        SharePost sp = new SharePost();
        sp.setPostSharer(ds.getValue(SharePost.class).getPostSharer());
        sp.setPostType(ds.getValue(SharePost.class).getPostType());