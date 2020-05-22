public Node<T>[] getSiblings ( )
{
    if (parent == null)
        return null;

    List<Node<T>> siblings = new ArrayList<Node<T>>( );
    Collections.copy(siblings, parent.children);
    siblings.remove(this);

    return siblings.toArray(new Node<T>[]{});
}