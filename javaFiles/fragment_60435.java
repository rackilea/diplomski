@Override
public String upload() {

  MessageContext mc = wsctx.getMessageContext();
  Map<String, DataHandler> atts = mc.get(MessageContext.INBOUND_MESSAGE_ATTACHMENTS);

  // ... 

  return "done";
}