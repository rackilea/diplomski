private LinkedList<E> copyRecursive(final Node<E> node, final LinkedList<E> accumulator) {
                if (node == null) {
                    // all nodes traversed, return the result.
                    return accumulator;
                }
                // add current node to the copy list that is under construction.
                accumulator.add(node.getElement());
                // recursive call to copy the rest of the nodes to the copy list and return it when finished.
                return copyRecursive(node.getNext(), accumulator);
            }