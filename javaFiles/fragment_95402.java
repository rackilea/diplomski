@Override
public Message process(Message pMessage) {
  try {
    pMessage = super.process(pMessage);
  } catch (Throwable wEx) {
    handleProcessError(pMessage, wEx);
  }
  return pMessage;
}