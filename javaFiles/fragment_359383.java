private final BlockingQueue<YourFunction> queue = ...

public void run() {
    while(!queue.isEmpty()) {
        queue.poll().performAction();
    }

    selector.select();

    Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
    while(itr.hasNext()) {
        // etc...
    }
}

public static void main(String[] args) {
    Timer t = new Timer(name, daemon);
    t.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            queue.add(new YourFunction());
            selector.wakeup();
        }
    }, 0, 1000);
}