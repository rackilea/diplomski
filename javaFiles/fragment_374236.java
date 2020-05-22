public class Deque implements DequeInterface {
    private Object[] array;
    private int      frontIndex;
    private Object[] rearIndex;
    public Deque() {
        // Allocate array of 100
        // Initialize front index and rear index
    }
    public void addFront(Object o) {
        if (array full) {
            // Increase array size
        }
        array[frontIndex--] = o;
        // Handle frontIndex circling around
    }
    public void addRead(Object o) {
        // TODO
    }
    public Object removeFront() {
        // TODO
    }
    public Object removeRear() {
        // TODO
    }
}