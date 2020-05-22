public class Worker implements Runnable {
    final private BlockingQueue<Integer> queue;
    final private float[] data;

    public Worker(BlockingQueue<Integer> queue) {
        this.queue = queue;
        this.data = data;
    }

    public void run() {
        while(true) {
            int i = queue.take();
            float f = data[i];
            // do something interesting to f
        }
    }
}


// *** Main Thread ***
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
float[] data = new float[12000];
for(int i = 0; i < 8; i++) {
    new Thread(new Worker(queue, data)).start();
}
for(int i = 0; i < data.length; i++) {
    if (data[i] >= 0.75) {
        queue.offer(i);
    }
}