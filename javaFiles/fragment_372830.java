class Node<T> {
    public T data;
    public Node<T> leftChild;
    public Node<T> rightChild;

    public void displayNode() {
        System.out.print('{');
        System.out.print(data.toString());
        System.out.print("} ");
   }
   . . .
}