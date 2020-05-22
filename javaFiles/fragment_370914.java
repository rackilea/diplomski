public class BinarySearchTree<E extends Comparable<? super E>> {
    BinaryNode<E> root;

    /**
     * Constructs an empty binary searchtree.
     */
    public BinarySearchTree() {

    }
    /**
     * Inserts the specified element in the tree if no duplicate exists.
     * @param element to be inserted
     * @return true if the the element was inserted
     */
    public boolean add(E element) {

        BinaryNode newNode = new BinaryNode(element);

        if(root==null){
            root=newNode;
            System.out.println("root");
        } if (element==root.element){ // element cannot be resolved or is not a field
            return false;
        } else {

            BinaryNode<E> focus = root;
            BinaryNode parent;

            while(true) {
                parent=focus;
                if (element.compareTo(focus.element) < 0) { //Here is my change!!! The operator < is undefined for the argument type(s) E, Object
                    focus=focus.left;
                    System.out.println("left");
                    if (focus==null) {
                        parent.left=newNode;
                        return true;
                    }
                } else {
                    focus=focus.right;
                    System.out.println("right");
                    if (focus==null) {
                        parent.right=newNode; //
                    }
                    return true;
                }
            }
        }

    }
    static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        private BinaryNode(E element) {
            this.element = element;
        }
    }

}