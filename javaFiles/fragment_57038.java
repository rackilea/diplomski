public class Tree<T> {

    private Node<T> rootElement;

    public Tree() {
        super();
    }

    public Node<T> getRootElement() {
        return this.rootElement;
    }

    public void setRootElement(final Node<T> rootElement) {
        this.rootElement = rootElement;
    }

    public List<Node<T>> toList() {
        final List<Node<T>> list = new ArrayList<Node<T>>();
        walk(this.rootElement, list);
        return list;
    }

    private void walk(final Node<T> element, final List<Node<T>> list) {
        list.add(element);
        for (final Node<T> data : element.getChildren()) {
            walk(data, list);
        }
    }
}