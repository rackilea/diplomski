class Node<T> {
    private List<Node<T>> children = new ArrayList<>();
    public T data;

    public boolean addChildNode(Node<T> child){
        children.add(child);
        return true;
    }

}