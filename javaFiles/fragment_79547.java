private void getMYuid() {
        String senderUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference mTest = FirebaseDatabase.getInstance().getReference();
        mTest.child(Constants.ARG_CHAT_GROUP_ROOMS).child("15052169227329_myGroupName_Hell By Anne").child(Constants.NEW_NODE)
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (!dataSnapshot.exists()){
                    Toast.makeText(ActivityChatView.this, "not exist", Toast.LENGTH_SHORT).show();
                    Log.e("151","ACV"+dataSnapshot);
                }

                // You can cast this object later but it seems that that is a string and not an array
                Object yourRequiredObject = dataSnapshot.child("usersIDS").getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Log.e("139","ACV"+senderUid);
    }