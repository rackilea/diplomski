DatabaseReference followersDB = FirebaseDatabase.getInstance().getReference("followers").child(user.getUid());
    followersDB.addListenerForSingleValueEven(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if(dataSnapshot.child("users").exists()) {
                int followersCount = dataSnapshot.child("count").getValue(Integer.class);
                //put value in view;
            } else  {
                //put 0 in view
            }
        }
    });