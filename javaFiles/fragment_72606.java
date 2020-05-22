public Message create(String beginString, String msgType) {
    MessageFactory messageFactory = messageFactories.get(beginString);
    if (beginString.equals(BEGINSTRING_FIXT11)) {
        // The default message factory assumes that only FIX 5.0 will be
        // used with FIXT 1.1 sessions. A more flexible approach will require
        // an extension to the QF JNI API. Until then, you will need a custom
        // message factory if you want to use application messages prior to
        // FIX 5.0 with a FIXT 1.1 session.
        //
        // TODO: how do we support 50/50SP1/50SP2 concurrently?
        //
        // If you need to determine admin message category based on a data
        // dictionary, then use a custom message factory and don't use the
        // static method used below.
        if (!MessageUtils.isAdminMessage(msgType)) {
            messageFactory = messageFactories.get(FIX50SP2);
        }
    }

    if (messageFactory != null) {
        return messageFactory.create(beginString, msgType);
    }

    Message message = new Message();
    message.getHeader().setString(MsgType.FIELD, msgType);

    return message;
}