public class EmailQueueHandler {


/** private Constructor */
private EmailQueueHandler() {}

/** Holder */
private static class EmailQueueHandlerHolder
{
    /** unique instance non preinitialized */
    private final static EmailQueueHandler INSTANCE = new EmailQueueHandler();
}

/** access point for unique instanciation of the singleton **/
public static EmailQueueHandler getInstance()
{
    return EmailQueueHandlerHolder.INSTANCE;
}

private List<EmailPreparator> queue = new ArrayList<>();


public void queue(EmailPreparator email) {
    waitForQueueHandlerToBeAvailable();
    queue.add(email);
}

public List<EmailPreparator> getQueue()
{
    waitForQueueHandlerToBeAvailable();
    List<EmailPreparator> preparators = queue;
    queue = new ArrayList<>();
    return preparators;
}

// This method is used to make this handler thread safe
private synchronized void waitForQueueHandlerToBeAvailable(){}
}