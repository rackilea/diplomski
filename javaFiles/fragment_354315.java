public class StackLL{
    private Node head; //Whatever is on top of the stack
    private int n; //Suze of the stack
    // the field next is not used; just delete it
//  private Node next;

    public StackLL(){
        head = null;
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void push(){
        Node temp = head;
        // The Node constructor takes two arguments
        head = new Node("Jim", 541365250);
        // x is not defined; delete this statement
//      head.x = x;
        // Node.next is not visible (it’s private), so use the setter 
        head.setNext(temp);
        n++;
    }

    public Node pop(){
        // if you want to return a Node, just return head
        Node x = head;
        // next is private, use the getter
        head = head.getNext();
        n--;
        return x;
    }

    public Node top(){
        // if you want to return a Node, just return head
        return head;
    }

    // printStack method for StackLL
    public void printStack() {
        System.out.println(n);
        Node temp = head;
        while (temp != null) {
        System.out.println(temp.getKey());
        temp = temp.getNext();
        }
    }

}