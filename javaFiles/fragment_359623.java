public Node<T> reverse(Node<T> current)
{
    if (current == head) {
        return reverse(current.next);
    }

    // rest of your original code.
}