main (...) {
    BlockingQueue<Task> queue = new LinkedBlockingQueue<>();


    for (int i=0;i<CPUs;i++) {
        new CPUThread(queue).start();
    }

    for (int i=0;i<GPUs;i++) {
        new GPUThread(queue).start();
    }

    for (/*all data*/) {
        queue.offer(task);
    }
}
class CPUThread {
    public void run() {
        while(/*some condition*/) {
            Task task = queue.take();
            //do task work
        }
    }
}
//etc...