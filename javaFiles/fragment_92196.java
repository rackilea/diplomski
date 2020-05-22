public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public void insert (int value) {

        if (root == null) {
            root = new Node(null, value);
        }
        else {
            insert(root, value);
        }
    }

    private void insert (Node parent, int value) {

        if (parent.value >= value) {

            if (parent.left == null) {
                parent.left = new Node (parent, value);
            }
            else {
                insert(parent.left, value);

           /////////////////////////    
                if ( parent.left.height() - parent.right.height() == 2) {

                    if (value - parent.left.value < 0) {
                        parent = rotateWithLeftChild(parent);
                    }
                    else {
                        parent = doubleRotateWithRightChild(parent);
                    }
                }           
          /////////////////////////
            }
        }

        else {

            if (parent.right == null) {
                parent.right = new Node (parent, value);
                System.out.println("Node inserted as a right child.");
            }
            else {
                System.out.println("We are in the insert method, before the recursive call");
                insert(parent.right, value);
                System.out.println("We are in the insert method, after the recursive call");
          /////////////////////////
                System.out.println("parent" + parent);
                System.out.println("parent.value " + parent.value);
                System.out.println("parent.left " + parent.left);
                System.out.println("parent.right " + parent.right);
                int leftHeight = 0;
                int rightHeight = 0;
                if( parent.left != null )
                    leftHeight = parent.left.height();

                if( parent.right != null )
                    rightHeight = parent.right.height();

                if ( leftHeight - rightHeight == -2) {

                    if (value - parent.right.value > 0) {
                        parent = rotateWithRightChild(parent);
                    }
                    else {
                        parent = doubleRotateWithLeftChild(parent);
                    }
                }
         /////////////////////////
        }
         }
         }
        public int quantity() {

    if (root == null) {
        return 0;
    }
    else {
        return 1 + quantity(root.left) + quantity(root.right);          
    }
     }
    public int quantity (Node parent) {

    if (parent == null) {
        return 0;
    }
    else {
        return 1 + quantity(parent.left) + quantity(parent.right);
    }
    }
    public int height () {

    int l = 0;
    int r = 0;

    if ( root.left != null) {
        l = height(root.left) + 1;
    }

    if (root.right != null) {
        r = height(root.right) +1;
    }

    return (Math.max(l,r));
    }
    private int height (Node parent) {

    int l = 0;
    int r = 0;

    if ( parent.left != null) {
        l = height(parent.left) + 1;
    }

    if (parent.right != null)   {
        r = height(parent.right) +1;
    }

    return (Math.max(l,r));
    }
    public String toString () {

        if (root == null) {
            return "empty tree";
        }
        else {
            return toString(root.left) + " ; " + root.value + " ; " +  toString(root.right);
        }
    }

    private String toString (Node parent) {

    if (parent == null) {
        return "";
    }
    else {
        return toString(parent.left) + " ; " + parent.value
        + " ; " +     toString(parent.right);
      }
     }
    private Node rotateWithLeftChild (Node k2) {
    Node k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;

    return k1;
    }
    private Node rotateWithRightChild (Node k1) {
    Node k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;

    return k2;
    }
    private Node doubleRotateWithRightChild (Node k3) {
    k3.left = rotateWithRightChild(k3.left);

    return rotateWithLeftChild(k3);
    }
    private Node doubleRotateWithLeftChild (Node k1) {
    k1.right = rotateWithLeftChild(k1.right);
    return rotateWithRightChild(k1);
    }

}