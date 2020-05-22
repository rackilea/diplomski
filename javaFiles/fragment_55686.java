public void createAndDispatch(DataInputStream input, MessageHandler handler) {
    MessageHeader header = ... read in from stream.

    if (header.type == MessageA.MESSAGE_TYPE) {
       handler.handleTypeA(new MessageA (din));
    } else if (header.type == MessageB.MESSAGE_TYPE) {
       handler.handleTypeB(new MessageB (din));
    }
}