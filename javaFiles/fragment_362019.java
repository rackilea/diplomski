private static class MyEventQueue extends EventQueue {

    private Deque<Runnable> onceIdle = new LinkedList<Runnable>();

    public MyEventQueue() {
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(this);
    }

    public void runOnceIdle(Runnable toRun) {
        onceIdle.addLast(toRun);
    }

    @Override
    protected void dispatchEvent(AWTEvent event) {
        super.dispatchEvent(event);
        if (peekEvent() == null) {
            for (Runnable toRun : onceIdle) {
                toRun.run();
            }
            onceIdle.clear();
        }
    }
}