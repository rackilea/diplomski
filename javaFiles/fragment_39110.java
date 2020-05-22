public class BlockingQueue<T> {

    private final LinkedList<T> innerList = new LinkedList<>();
    private boolean isEmpty = true;

    public synchronized T take() throws InterruptedException {
        while (isEmpty) {
            wait();
        }

        T element = innerList.removeFirst();
        isEmpty = innerList.size() == 0;
        return element;
    }

    public synchronized void put(T element) {
        isEmpty = false;
        innerList.addLast(element);
        notify();
    }
}