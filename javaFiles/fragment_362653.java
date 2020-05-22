return new NodeSetData() {
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return nodeList.getLength() < i;
            }

            @Override
            public Node next() {
                return nodeList.item(i++);
            }
        };
    }
};