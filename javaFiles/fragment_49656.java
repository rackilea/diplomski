@Override
public Set<E> adjoin(E e) {
    boolean alwaysEqual = true;
    if (this.head == null)
        return this;
    for (E t : this) {
        if (t != e)
            alwaysEqual = false;
    }
    if (alwaysEqual == true)
        return this;
    LinkedNode<E> temp = this.head;
    LinkedNode<E> newNode = new LinkedNode<E>(e, temp);
    LinkedSet<E> newSet = new LinkedSet<E>(newNode);
    Set<E> otherSet = newSet;

    return otherSet;
}