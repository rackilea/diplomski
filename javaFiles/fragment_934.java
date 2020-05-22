FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String current_uid = user.getUid(); // user.getUid() will return null if you are not log in
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    Query query = db.child("Leads").child("Generated").orderByChild("userid").equalTo(current_uid);
    query.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

                      // do something

            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });