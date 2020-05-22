// To declare the Queue
public static final ConcurrentLinkedQueue<QueueItem> myQueue = new ConcurrentLinkedQueue<QueueItem>();
public static boolean Terminated=false;

// To queue something do like this:
    QueueItem qItem = new QueueItem("This is a test message".getBytes());
    myQueue.add(qItem);