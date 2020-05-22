//from EventQueue.java...

private static final int LOW_PRIORITY = 0;
private static final int NORM_PRIORITY = 1;
private static final int HIGH_PRIORITY = 2;
private static final int ULTIMATE_PRIORITY = 3;

private static final int NUM_PRIORITIES = ULTIMATE_PRIORITY + 1;

/*
 * We maintain one Queue for each priority that the EventQueue supports.
 * That is, the EventQueue object is actually implemented as
 * NUM_PRIORITIES queues and all Events on a particular internal Queue
 * have identical priority. Events are pulled off the EventQueue starting
 * with the Queue of highest priority. We progress in decreasing order
 * across all Queues.
 */
private Queue[] queues = new Queue[NUM_PRIORITIES];

//...skipped some parts...

/**
 * Causes <code>runnable</code> to have its <code>run</code>
 * method called in the {@link #isDispatchThread dispatch thread} of
 * {@link Toolkit#getSystemEventQueue the system EventQueue}.
 * This will happen after all pending events are processed.
 *
 * @param runnable  the <code>Runnable</code> whose <code>run</code>
 *                  method should be executed
 *                  asynchronously in the
 *                  {@link #isDispatchThread event dispatch thread}
 *                  of {@link Toolkit#getSystemEventQueue the system EventQueue}
 * @see             #invokeAndWait
 * @see             Toolkit#getSystemEventQueue
 * @see             #isDispatchThread
 * @since           1.2
 */
public static void invokeLater(Runnable runnable) {
    Toolkit.getEventQueue().postEvent(
        new InvocationEvent(Toolkit.getDefaultToolkit(), runnable));
}

/**
 * Posts a 1.1-style event to the <code>EventQueue</code>.
 * If there is an existing event on the queue with the same ID
 * and event source, the source <code>Component</code>'s
 * <code>coalesceEvents</code> method will be called.
 *
 * @param theEvent an instance of <code>java.awt.AWTEvent</code>,
 *          or a subclass of it
 * @throws NullPointerException if <code>theEvent</code> is <code>null</code>
 */
public void postEvent(AWTEvent theEvent) {
    SunToolkit.flushPendingEvents(appContext);
    postEventPrivate(theEvent);
}

/**
 * Posts a 1.1-style event to the <code>EventQueue</code>.
 * If there is an existing event on the queue with the same ID
 * and event source, the source <code>Component</code>'s
 * <code>coalesceEvents</code> method will be called.
 *
 * @param theEvent an instance of <code>java.awt.AWTEvent</code>,
 *          or a subclass of it
 */
private final void postEventPrivate(AWTEvent theEvent) {
    theEvent.isPosted = true;
    pushPopLock.lock();
    try {
        if (nextQueue != null) {
            // Forward the event to the top of EventQueue stack
            nextQueue.postEventPrivate(theEvent);
            return;
        }
        if (dispatchThread == null) {
            if (theEvent.getSource() == AWTAutoShutdown.getInstance()) {
                return;
            } else {
                initDispatchThread();
            }
        }
        postEvent(theEvent, getPriority(theEvent));
    } finally {
        pushPopLock.unlock();
    }
}

private static int getPriority(AWTEvent theEvent) {
    if (theEvent instanceof PeerEvent) {
        PeerEvent peerEvent = (PeerEvent)theEvent;
        if ((peerEvent.getFlags() & PeerEvent.ULTIMATE_PRIORITY_EVENT) != 0) {
            return ULTIMATE_PRIORITY;
        }
        if ((peerEvent.getFlags() & PeerEvent.PRIORITY_EVENT) != 0) {
            return HIGH_PRIORITY;
        }
        if ((peerEvent.getFlags() & PeerEvent.LOW_PRIORITY_EVENT) != 0) {
            return LOW_PRIORITY;
        }
    }
    int id = theEvent.getID();
    if ((id >= PaintEvent.PAINT_FIRST) && (id <= PaintEvent.PAINT_LAST)) {
        return LOW_PRIORITY;
    }
    return NORM_PRIORITY;
}

/**
 * Posts the event to the internal Queue of specified priority,
 * coalescing as appropriate.
 *
 * @param theEvent an instance of <code>java.awt.AWTEvent</code>,
 *          or a subclass of it
 * @param priority  the desired priority of the event
 */
private void postEvent(AWTEvent theEvent, int priority) {
    if (coalesceEvent(theEvent, priority)) {
        return;
    }

    EventQueueItem newItem = new EventQueueItem(theEvent);

    cacheEQItem(newItem);

    boolean notifyID = (theEvent.getID() == this.waitForID);

    if (queues[priority].head == null) {
        boolean shouldNotify = noEvents();
        queues[priority].head = queues[priority].tail = newItem;

        if (shouldNotify) {
            if (theEvent.getSource() != AWTAutoShutdown.getInstance()) {
                AWTAutoShutdown.getInstance().notifyThreadBusy(dispatchThread);
            }
            pushPopCond.signalAll();
        } else if (notifyID) {
            pushPopCond.signalAll();
        }
    } else {
        // The event was not coalesced or has non-Component source.
        // Insert it at the end of the appropriate Queue.
        queues[priority].tail.next = newItem;
        queues[priority].tail = newItem;
        if (notifyID) {
            pushPopCond.signalAll();
        }
    }
}