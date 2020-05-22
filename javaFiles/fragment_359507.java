class MyEventQueue {
    Queue<Runnable> queue = new LinkedList<Runnable>();
    public void invokeLater(Runnable r) {
        queue.add(r);
    }
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    public void processNext() {
        queue.poll.run();
    }
}