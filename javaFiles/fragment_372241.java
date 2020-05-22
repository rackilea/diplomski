public class NodeTest {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node a = new Node(1, "A");
        Node b = new Node(2, "B");
        Node c = new Node(3, "C");
        Node d = new Node(4, "D");
        Node e = new Node(5, "E");
        Node f = new Node(6, "F");
        Node g = new Node(7, "G");
        Node h = new Node(8, "H");
        Node i = new Node(9, "I");
        f.leftChild = b;
        b.leftChild = a;
        b.rightChild = d;
        d.leftChild = c;
        d.rightChild = e;
        f.rightChild = g;
        g.rightChild = i;
        i.leftChild = h;
        bt.root = f;

        System.out.println("Print full tree:");
        BinaryTree.preOrderPrint(bt.copyTree(f));

        System.out.println("Only print f's left sub-tree:");
        BinaryTree.preOrderPrint(bt.copyTree(f.leftChild));

    }

}