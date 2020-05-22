public interface MyQueue {
    public void enqueue(Object item);
    public Object dequeue();
    public boolean isEmpty();
    public int size();
    public Object peek();
}