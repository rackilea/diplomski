DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference uidRef = rootRef.child("users").child(uid);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ArrayList<ChatMessageModel> messageList = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            ChatMessageModel chatMessageModel = ds.getValue(ChatMessageModel.class);
            Log.d("users:: ", chatMessageModel.getMsgContent());
            messageList.add(chatMessageModel);
        }

        //Do what you need to do with the list.
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
uidRef.addListenerForSingleValueEvent(valueEventListener);