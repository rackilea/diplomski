@Override
public String toString() {
    final StringJoiner stringJoiner = new StringJoiner("\n");

    for (Node<T> node = head; node != null; node = node.right) {
        stringJoiner.add(node.item.toString());
    }

    return stringJoiner.toString();
}