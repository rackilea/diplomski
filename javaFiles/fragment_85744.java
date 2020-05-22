public class BinaryTree {

    /* ... */


    //each recursive call receives a pair of bounds for the part of the 
    //array it has to process: left and right
    public static BinaryTreeNode nodeFromSortedArray(String[]a,
                                           int left, int right){

        if (right<left) return null;

        if (right==left)
            return new BinaryTreeNode(a[left]);

        int mid = (left+right)/2;

        //create node from middle element
        BinaryTreeNode n = new BinaryTreeNode(a[mid]);

        //recursively add elements to the left as its right subtree
        n.left = nodeFromSortedArray(a, left, mid-1);

        //recursively add elements to the right as its right subtree
        n.right = nodeFromSortedArray(a, mid+1, right);

        return n;
    }

    public static BinaryTree fromSortedArray(String[]a){
        BinaryTree bt = new BinaryTree();
        bt.setRoot(nodeFromSortedArray(a,0,a.length-1));
        return bt;
    }

    /* ... */
}