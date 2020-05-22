public class Stack() {
    private StackElement head = null;
    public push(Integer value) {
        StackElement topush = new StackElement(value);
        topush.setNext(head);
        head = topush;
    }
    public Integer pop() {
        StackElement topop = head;
        if (head != null) {
            head = topop.getNext();
            return topop.getValue();
        }
        return null;
    }
}