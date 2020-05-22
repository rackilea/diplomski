class LabeledNode<T> extends Node<T> {
    T data;
    LabeledNode<T> left;
    LabeledNode<T> right;
    int preOrderNum;
    int inOrderNum;
    int postOrderNum;

    public LabeledNode(T data, LabeledNode<T> left, LabeledNode<T> right);
}