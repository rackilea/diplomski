Chat newChat = chatmanager.createChat("ehsan@<service name>" ,new ChatMessageListener() {
    @Override
    public void processMessage(Chat chat, Message message) {
        Log.d("","message :"+  message.getBody());
    }
});