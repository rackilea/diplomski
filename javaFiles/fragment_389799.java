class Thing {
}

class ServerThread implements Runnable {

    @Override
    public void run() {
        BlockingQueue<Thing> q = new ArrayBlockingQueue<>(1024);
        ListenerThread lt = new ListenerThread(q);
        new Thread(lt).start();

        q.put(message);

    }
}

class ListenerThread implements Runnable {

    volatile boolean run;
    private final BlockingQueue<Thing> q;

    public ListenerThread (BlockingQueue<Thing> q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (run) {
            try {
                sendMessage(q.take());
            } catch (InterruptedException ex) {
                run = false;
            }
        }
    }
}