DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
String chatKey = rootRef.push().getKey();
String messageKey = rootRef.push().getKey();
Message newMessage = new Message(chatKey, "My message trial", Calendar.getInstance().getTimeInMillis());
Map<String, Boolean> messageKeys = new LinkedHashMap<>();
messageKeys.put(messageKey, true);
Chat newChat = new Chat(messageKeys);
rootRef.child("messages").child(messageKey).setValue(newMessage);
rootRef.child("chats").child(chatKey).setValue(newChat);