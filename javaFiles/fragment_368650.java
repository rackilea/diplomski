//E is a type parameter, meaning HLinkedList<E> is generic
public class HLinkedList<E> extends java.util.AbstractSequentialList<E> {

    //I think you can keep this private here, this only helps you to implement your
    //version of AbstractSequentialList, for anyone who will be using HLinkedList
    //are not going to worry about it
    private static class HTreeNode {
        public HTreeNode left;
        public HTreeNode right;
        public HTreeNode next;
        public int frequency;
        public char value;
        public String code;

        public HTreeNode(int freq, char val, HTreeNode l, HTreeNode r, HTreeNode n, String code)  {
            value = val;
            frequency = freq;
            left = l;
            right = r;
            next = n;
            code = ""; 
        }
    }

    private HTreeNode head;
    private int nItem; //made this non-static, each instance will need it's own copy

    public HLinkedList()  {
        this.head = null;
        this.nItem = 0;
    }

    public void insertIntoPosition(E element, int position)  {
        // probably create a new node here for element
        // and fix it at the location specified
    }

    //This is an abstract method declared in AbstractSequentialList
    //You need provide an implementation of it
    @Override
    public ListIterator<E> listIterator(int index) {

        return null;
    }

    //This is an abstract method declared in AbstractSequentialList
    //You need provide an implementation of it    
    @Override
    public int size() {

        return 0;
    }
}