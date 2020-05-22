private LinkedList<E> copyRecursive(final Node<E> node) {
                    if (node == null) {
                        return new LinkedList<>();
                    }
                    final LinkedList<E> accumulator = copyRecursive(node.getNext());
                    accumulator.add(node.getElement());
                    return accumulator;
                }