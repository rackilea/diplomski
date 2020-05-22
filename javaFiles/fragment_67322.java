public class DLLNode{

    private int data;
    private DLLNode prev;
    private DLLNode next;

    public int whatsNext() {
        return next.data; // btw, a null check if always encouraged :)
    }
}