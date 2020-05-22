private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
...

@Override
public onDataAvailable(int val){
    System.out.println("listener received val: " + val);
    queue.put(val);
}
...

generatorThread.addListener(listener);
generatorThread.start();
while (true) {
    // this waits for the queue to get a value
    int val = queue.take();
    System.out.println("value is: " + val);
}