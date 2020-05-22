DatabaseReference ref=FirebaseDatabase.getInstance().getReference();
Query query=ref.child("Users").orderByChild("name").equalTo(name);
FirebaseRecyclerOptions<AllUsers> options =
    new FirebaseRecyclerOptions.Builder<AllUsers>()
            .setQuery(query, AllUsers.class)
            .build();

FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<AllUsers, UsersViewHolder>(options) {