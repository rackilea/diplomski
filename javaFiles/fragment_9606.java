static final int INITIAL_MESSAGE_COUNT = ...;

AtomicInteger messageCount = new AtomicInteger(INITIAL_MESSAGE_COUNT);

public int getMessageCount()
{
    return messageCount.get();
}

public void onMessage(XQMessage msg) throws XQServiceException
{
    int mc = messageCount.decrementAndGet();
    messages.add(msg);
    if (mc == 0) wake_up_client();
}