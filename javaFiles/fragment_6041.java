public class BinaryTree {
    Integer integerValue;
    BinaryTree left, right;

    public BinaryTree(int[] string, int currentPosition) {
        if (currentPosition < string.length){
            this.integerValue = string[currentPosition];
            this.left = new BinaryTree(string, 2 * currentPosition + 1);
            this.right = new BinaryTree(string, 2 * currentPosition + 2);
        }
    }

    public void printTree() {
        if (this.integerValue != null){
            System.out.print(this.integerValue + " ");
            this.left.printTree();
            this.right.printTree();
        }
    }
}