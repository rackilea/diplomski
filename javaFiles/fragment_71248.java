public class StringQueueImpl implements StringQueue {
    private QueueCell head;
    private int size = 0;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(String c) {
        if(head == null){
            head = new QueueCell(c);
        } else {
            QueueCell current = head;
            while(current != null){
                if(current.next == null){
                    current.next = new QueueCell(c);
                    break;
                } else {
                    current = head.next;
                }
            }
        }
        size++;
    }

    @Override
    public String front() throws QueueException {
        if(size == 0 || head == null){
            throw new QueueException();
        }
        return head.value;
    }

    @Override
    public void removeFront() throws QueueException {
        if(size == 0 || head == null){
            throw new QueueException();
        }

        if(head.next != null){
            head = head.next;
        } else { // if only 1 element is in the queue
            head = null;
        }
        size--;
    }

    private static class QueueCell {
        private QueueCell next;
        private String value;

        QueueCell(String s){
            value = s;
        }
    }

    public static class QueueException extends RuntimeException {
        public QueueException(){
            super("Queue is empty");
        }
    }
}