public class TreeIterator {
    private Node next;

    public TreeIterator(Node root) {
        next = root;
        if(next == null)
            return;

        while (next.left != null)
           next = next.left;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Node next(){
        if(!hasNext()) throw new NoSuchElementException();
        Node r = next;

        // If you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.right != null) {
            next = next.right;
            while (next.left != null)
                next = next.left;
            return r;
        }

        while(true) {
            if(next.parent == null) {
                next = null;
                return r;
            }
            if(next.parent.left == next) {
                next = next.parent;
               return r;
            }
            next = next.parent;
        }
     }
 }