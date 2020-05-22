FirebaseDatabase.getInstance().getReference().child("Posts")
        .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                   HashMap<String, Object> post = (HashMap<String, Object>) dataSnapshot.getValue();
                   total= post.size();

                }
      }