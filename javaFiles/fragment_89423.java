public Sender pool.findOrCreateSenderForMessageType(MessageType type) {
    Sender sender = cache.findByType(type);
    if(sender == null) {
        sender = factory.createSender(type);
        cache.addSenderForType(sender, type);
    }
    return sender;
}