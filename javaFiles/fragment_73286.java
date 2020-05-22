public class QueueProgram {
    private int queuesize = 10;

    public int getQueuesize() {
        return queuesize;
    }

    public void setQueuesize(int size) {
        queuesize = size;
    }

    public static void main(String[] args) {
        QueueProgram program = new QueueProgram();
        program.getQueuesize(); // return 10;
        program.setQueuesize(5);
        program.getQueuesize(); // now it is 5;
   }
}