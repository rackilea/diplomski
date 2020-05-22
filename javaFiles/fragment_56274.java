public class PrintQueue {
    private final Queue<Job> queue;

    public PrintQueue() {
        queue = new Queue<Job>();
    }

    public void lpr(String owner, int jobID) {
        queue.enqueue(new Job(owner, jobID));
    }
}