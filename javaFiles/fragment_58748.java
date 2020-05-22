DatabaseReference chatsRef = FirebaseDatabase.getInstance().getReference("chats");
DatabaseReference messagesRef = FirebaseDatabase.getInstance().getReference("messages");

messagesRef.orderByChild("text").equalTo("Test1").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            String messageKey = child.getKey();
            Message message = child.getValue(Message.class);
            String chatKey = message.getChatKey();
            // Now you have both the chatKey and the messageKey...
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});