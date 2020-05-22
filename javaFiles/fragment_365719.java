public Node<T> (Node<T> parent, T value)
{
    this.parent = parent;
    this.value = value;

    // Don't forget: if you have a parent, you are their child.
    parent.addChild(this);
}