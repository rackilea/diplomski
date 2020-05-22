public class QueueTest {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        EventQueue eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        eventQueue.push(new MyEventQueue());

        EventQueue.invokeAndWait(new Runnable() {
            public void run() {
                System.out.println("Run");
            }
        });
    }

    private static class MyEventQueue extends EventQueue {
        public void postEvent(AWTEvent theEvent) {
            System.out.println("Event Posted");
            super.postEvent(theEvent);
        }
    }
}