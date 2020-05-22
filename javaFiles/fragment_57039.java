public class Node<T> {

    private T data;
    private List<Node<T>> children;

    public Node() {
        super();
    }

    public Node(final T data) {
        this();
        setData(data);
    }

    public Boolean hasChildren() {
        return this.children.size() != 0;
    }

    public List<Node<T>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Node<T>>();
        }
        return this.children;
    }

    public void setChildren(final List<Node<T>> children) {
        this.children = children;
    }

    public int getNumberOfChildren() {
        return this.children.size();
    }

    public void addChild(final Node<T> child) {
        if (this.children == null) {
            this.children = new ArrayList<Node<T>>();
        }
        this.children.add(child);
    }

    public void insertChildAt(final int index, final Node<T> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            addChild(child);
            return;
        } else {
            this.children.get(index);
            this.children.add(index, child);
        }
    }

    public void removeChildAt(final int index) throws IndexOutOfBoundsException {
        this.children.remove(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}