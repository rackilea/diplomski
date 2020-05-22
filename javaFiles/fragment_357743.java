final User newUser = new User();
    newUser.email = user.getEmail();
    newUser.name = user.getDisplayName();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.hasChild("user/" + user.getUid())) {
                //User Exists , No Need To add new data.
                //Get previous data from firebase. It will take previous data as soon as possible..
                return;
            } else {
                FirebaseDatabase.getInstance().getReference().child("user/" + user.getUid()).setValue(newUser);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });