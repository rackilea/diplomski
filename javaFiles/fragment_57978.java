@Override
public String toString() {
    final StringJoiner stringJoiner = new StringJoiner("\n");

    Node<?> node = head;

    while (node != null) {
        stringJoiner.add(node.item.toString());
        node = node.right;
    }

    return stringJoiner.toString();
}