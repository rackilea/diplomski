String chatKey = "chatKey1";   // Get it somehow
DatabaseReference messagesRef = FirebaseDatabase.getInstance().getReference("messages");

messagesRef.orderByChild("chatKey").equalTo(chatKey).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Message> messageList = new ArrayList<>();
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            String messageKey = child.getKey();
            Message message = child.getValue(Message.class);
            messageList.add(message);
        }
        // Now you have all messages in messageList...
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});