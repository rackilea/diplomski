class AWTInvocationLock {}
    Object lock = new AWTInvocationLock();

    InvocationEvent event =
        new InvocationEvent(source, runnable, lock, true);

    synchronized (lock) {
        Toolkit.getEventQueue().postEvent(event);
        while (!event.isDispatched()) {
            lock.wait();
        }
    }