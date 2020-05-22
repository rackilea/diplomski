class DagIterator<T>
    extends Iterator<T> {

        private Stack<DagNode<T>> nodes;

        private DagIterator(Dag<T> dag) {
            nodes.push(dag.getRootNode());
        }

        public boolean hasNext() {
            return ! nodes.isEmpty();      
        }

        public T next() {
            final DagNode node = nodes.pop();
            for (final DagNode child : node.getChildren()) {
                nodes.push(child);
            }
            return node.getValue();
        }

    }