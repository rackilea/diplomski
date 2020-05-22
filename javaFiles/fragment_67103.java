fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forum1.child("_forum1_").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                      for(DataSnapshot ds : dataSnapshot.getChildren()){
                        String msg = ds.child("message").getValue(String.class);
                        String value = ds.child("post_title").getValue(String.class);
                        post_update.setText(value +" "+ msg);
                     }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });